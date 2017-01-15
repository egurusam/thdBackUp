package dashboard.service.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import dashboard.service.GitHubService;
import dashboard.to.GitFileContentTO;
import dashboard.to.GitHubFileSearchTO;
import dashboard.to.Item;

public class GitHubServiceImpl implements GitHubService {
	private static Logger logger = Logger.getLogger(GitHubServiceImpl.class);
	
	@SuppressWarnings("deprecation")
	public HashMap<String, List<String>> testCases(String fileName){
	
		logger.info("Inside Search method");
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", "token 85893700ce7b7a840763604448a74811cac9ef53");
	    HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);
	    boolean hasNext = false;
	    HashMap<String, String> gitFileUrlMap = new HashMap<String,String>(); 
	    String url="https://github.homedepot.com/api/v3/search/code?q=filename:RunManager.xls";
	    do{
	    	HashMap<String, String> paginationInfoMap= new HashMap<String, String>();
	    	hasNext = false;
	    	logger.info("Git Hub URL ========== " +url);
	    	ResponseEntity<GitHubFileSearchTO> response = restTemplate.exchange(url,
		    		HttpMethod.GET,httpEntity, GitHubFileSearchTO.class);
		    logger.info("Status" +response.getStatusCode());
		    logger.info("Headers"+response.getHeaders());
		    logger.info("Inside Retrieve Projects"+response);
			
		    GitHubFileSearchTO gitFileSearchTO = response.getBody();
		    
			  if(null != response.getHeaders().get("Link")){
				  
				 	for(String linkList: response.getHeaders().get("Link")){
					logger.info("Header Info ======"+linkList);
					StringTokenizer token = new StringTokenizer(linkList, ",");
					while(token.hasMoreTokens()){
						String tokenValue=(null!=token? token.nextToken():null);
						logger.info("tokenValue ======"+tokenValue);
						if(null!= tokenValue && !"".equals(tokenValue)){
							StringTokenizer subToken= new StringTokenizer(tokenValue,";");
							logger.info(" sub Token"+subToken);
							while(subToken.hasMoreTokens()){
								String value = subToken.nextToken();
								String key= subToken.hasMoreTokens()?subToken.nextToken():null;
								if(key!=null && value !=null){
									value=value.replaceAll("[<>]","");
									paginationInfoMap.put(key, value);
									if(key.contains("rel=\"next\"")){
										hasNext=true;
										url=URLDecoder.decode(value);
									}
							}
						}
					}
				}
				}
				logger.info("=== Pagination Header Info =====");
				for(String key:paginationInfoMap.keySet()){
					logger.info("Key"+key+"Value"+paginationInfoMap.get(key));
				}
			}  
			  if (null != gitFileSearchTO.getItems()) {
					for (Item item : gitFileSearchTO.getItems()) {
						String fileURL = (null != item.getUrl() ? URLDecoder.decode(item.getUrl()) : "");
						String projectName = (null != item.getRepository() ? item.getRepository().getName() : "");
						if (!"".equals(fileURL) && (null != projectName && !"".equals(projectName))) {
							gitFileUrlMap.put(projectName, fileURL);//assigns file path url to project name
						}
					}
				}
	    }while(hasNext);
	    
	    //Downloading Files from GIt Hub
	    HashMap<String, List<String>> userStoriesMap = new HashMap<String, List<String>>();
	    logger.info("Total Size of the url Map"+gitFileUrlMap.size());
	    for(String key:gitFileUrlMap.keySet()){
	    	String fileUrl = gitFileUrlMap.get(key);
	    	String Save_RunManager_Path = System.getProperty("user.dir") + "\\temp\\"+key + ".xls";
	    	try{
	    	ResponseEntity<GitFileContentTO> response = restTemplate.exchange(fileUrl,
		    		HttpMethod.GET,httpEntity, GitFileContentTO.class);
	    	
	    	if(response.getStatusCode().is2xxSuccessful()){
	    	 
	    	GitFileContentTO gitFileContentTO = response.getBody();
	    	logger.info(" File Type "+gitFileContentTO.getType());
	    	 if(gitFileContentTO.getType().equalsIgnoreCase("file")){	
		    	File file = new File(Save_RunManager_Path);
		    	
				try {
					BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
					writer.write(Base64.decodeBase64(gitFileContentTO.getContent()));
					writer.flush();
					writer.close();
					retrieveTestcasesNameFromRunMangaer(Save_RunManager_Path, userStoriesMap);
				} catch (IOException e) {
					logger.error("Received IO Exception while working with the File"+file.getPath());
				} catch (Exception e) {
					logger.error("Received Exception while identifying test cases from the file "+file.getPath());
				}finally{
					logger.info("Deleting the File "+file.getPath());
					//file.delete();
				}
		    }
	    } else{
	    	logger.error(" Received Exception for the url"+fileUrl);
	    	continue;
	    	}
	    }catch(Exception e ){
	    	logger.error("Received Exception while retrieveing files from Git Hub");
	    	continue;
	    }
	    }
		return userStoriesMap;
	}
	
	/**
	 * 
	 * @param filePath
	 * @param userStoryDetailsMap
	 * @throws IOException
	 */
	public static void retrieveTestcasesNameFromRunMangaer(String filePath,
			HashMap<String, List<String>> userStoryDetailsMap) throws IOException {
		int testcaseColumn = 0;
		List<String> listOftestcases = new ArrayList<>();
		File runManagerFile = new File(filePath);
		if (runManagerFile.exists() & !runManagerFile.isDirectory()) {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheet("BDD");
			int rowNum = sheet.getLastRowNum() + 1;
			int colNum = sheet.getRow(0).getLastCellNum();

			for (int j = 0; j < colNum; j++) {

				String colValues = sheet.getRow(0).getCell(j).getStringCellValue();
				if (colValues.equalsIgnoreCase("Test Case Name")) {
					testcaseColumn = j;
					break;
				}
			}

			for (int i = 0; i < rowNum; i++) {
				String colValues = sheet.getRow(i).getCell(testcaseColumn).getStringCellValue();
				listOftestcases.add(colValues);
				// Constants.logger.debug("Scenario Name From RunManager :" +
				// colValues);
			}
			workbook.close();
		}
		retrieveUserStoryIdAndItsTestcases(listOftestcases, userStoryDetailsMap);
		// return userStoryDetailsMap;
	}

	
	/**
	 * 
	 * @param listFromRunManager
	 * @param userStoryTestCases
	 */
	public static void retrieveUserStoryIdAndItsTestcases(List<String> listFromRunManager,
			HashMap<String, List<String>> userStoryTestCases) {

		String userStroyID = null;
		String testcaseName = null;

		for (String individualStory : listFromRunManager) {
			int CountofSlash = 0;
			char[] getID_Index = individualStory.toCharArray();
			int getID_Index_Count = getID_Index.length;
			for (int i = 0; i < getID_Index_Count / 2 - 1; i++) {
				if (getID_Index[i] == '/') {
					CountofSlash = i++;
				}
			}
			if (CountofSlash >= 2 && individualStory.contains("/")) {
				if (getID_Index[0] == '/' || getID_Index[getID_Index_Count - 1] == '/') {
					if (getID_Index[0] == '/') {
						userStroyID = individualStory.substring(1, individualStory.length());
						int countStarFortestcases = userStroyID.indexOf("/");
						userStroyID = userStroyID.substring(0, userStroyID.indexOf("/"));
						// userStroyID=userStroyID.substring(0,
						// userStroyID.indexOf("_"));
						testcaseName = individualStory.substring(countStarFortestcases + 1, individualStory.length());
						// Constants.logger.debug("User Story :" + userStroyID +
						// "was placed first");
						// Constants.logger.debug(userStroyID +" : Associated
						// testcase " + testcaseName);
					} else if (getID_Index[getID_Index_Count - 1] == '/') {
						userStroyID = individualStory.substring(0, individualStory.length() - 1);
						int CountLengthBeforeID = userStroyID.lastIndexOf("/");
						userStroyID = userStroyID.substring(userStroyID.lastIndexOf("/") + 1,
								individualStory.length() - 1);
						testcaseName = individualStory.substring(0, CountLengthBeforeID);
						// Constants.logger.debug("User Story :" + userStroyID +
						// "was placed last");
						// Constants.logger.debug(userStroyID +" : Associated
						// testcase " + testcaseName);
					}

					if (null != userStoryTestCases.get(userStroyID)) {
						userStoryTestCases.get(userStroyID).add(testcaseName);
					} else {
						userStoryTestCases.put(userStroyID, new ArrayList<String>());
						userStoryTestCases.get(userStroyID).add(testcaseName);
					}
				}
			} else {
				userStroyID = "-1";
				if (null != userStoryTestCases.get(userStroyID)) {
					List<String> tempList = userStoryTestCases.get(userStroyID);
					tempList.add(individualStory);
					userStoryTestCases.put(userStroyID, tempList);
				} else {
					List<String> tempList = new ArrayList<String>();
					tempList.add(individualStory);
					userStoryTestCases.put(userStroyID, tempList);
				}
			}
		}
		// return userStoryTestCases;
	}



}
