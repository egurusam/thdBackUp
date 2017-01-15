package dashboard.controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dashboard.service.GitHubService;
import dashboard.service.PivotalService;
import dashboard.service.impl.GitHubServiceImpl;
import dashboard.service.impl.PivotalServiceImpl;
import dashboard.to.Label;
import dashboard.to.PivotalProjects;
import dashboard.to.PivotalUserStory;
import dashboard.to.ProjectDetails;
import dashboard.to.UserStoryDetails;

@RestController
public class DashboardController {
	
	private static Logger logger=Logger.getLogger(DashboardController.class);
	
	/**
	 * Method retrieves all project details for a user
	 * @param userName
	 * @return
	 */
	@RequestMapping("/projects")
	public @ResponseBody List<ProjectDetails> retrieveProjects(@RequestParam(value="user", defaultValue="") String userName){
		
		logger.info("Projects Retrieval Service requested for the user "+userName);

		PivotalService pivotalService = new PivotalServiceImpl();
		List<ProjectDetails> projectDetailsList = pivotalService.retrieveProjects(userName);
		for(ProjectDetails projectDetail:projectDetailsList){
			logger.info("Project :"+projectDetail.getProjectID());
			logger.info("Project :"+projectDetail.getProjectName());
		}
		return projectDetailsList;
	}
	
	/**
	 * Method retrieves details about a project 
	 * @param projectID
	 * @return
	 */
	@RequestMapping("/projects/{projectID}")
	public @ResponseBody PivotalProjects retrieveProject(@PathVariable(value="projectID") Long projectID){
		logger.info("Service requested for project details for the ID "+projectID);
		PivotalService pivotalService = new PivotalServiceImpl();
		PivotalProjects pivotalProjects = pivotalService.retrieveProject(projectID);
		return pivotalProjects;
	}
	
	
	
	/**
	 * Method to retrieve all user stories for a user
	 * @param userStoryID
	 * @return
	 */
//	@RequestMapping("/{projectID}/userStories")
	@RequestMapping("/userStories")
	public @ResponseBody List<UserStoryDetails> retrieveUserStories(@RequestParam(value="projectID") String projectID,@RequestParam(value="limit") String limit,
			@RequestParam(value="offset") String offset){
		
		logger.info("Inside retrive User Storoies");
		HashMap<String, List<String>>  testCasesMap = searchForTestCases();
		logger.info("Map Size "+ testCasesMap.size());
		logger.info("inside userStories limit"+limit+" offset"+ offset);
		List<PivotalUserStory> userStories = null;
		PivotalService pivotalService = new PivotalServiceImpl();
		List<UserStoryDetails> userStoriesList = new ArrayList<UserStoryDetails>();
		for (String key: testCasesMap.keySet()){
			logger.info("Key " + key);
		}
		
		if(null== offset || null==limit){
			userStories = pivotalService.retrieveUserStoriesDefault(projectID);
		}else{
			userStories  = pivotalService.retrieveUserStoriesPaginated(projectID, offset, limit);
		}
		
		for(PivotalUserStory pivotalUserStory : userStories){
			UserStoryDetails userStoryDetails = new UserStoryDetails();
			userStoryDetails.setUserStoryID(pivotalUserStory.getId());
			userStoryDetails.setName(pivotalUserStory.getName());
			userStoryDetails.setUserStoryDescription(pivotalUserStory.getDescription());
			userStoryDetails.setUserStoryType(pivotalUserStory.getStoryType());
			userStoryDetails.setStatus(pivotalUserStory.getCurrentState());
			List<String> labelNameList = new ArrayList<String>();
			for(Label label:pivotalUserStory.getLabels()){
				String labelName = label.getName();
				labelNameList.add(labelName);
			}
			userStoryDetails.setLabelName(labelNameList);
			logger.info("Test Project ID  "+pivotalUserStory.getId());
			logger.info("Test Cases "+testCasesMap.get(pivotalUserStory.getId().toString()));
			List<String> testCases = testCasesMap.get(pivotalUserStory.getId().toString());
			userStoryDetails.setTestCases(testCases);
						int testCasesCount = null!= testCases ? testCases.size():0;
			userStoryDetails.setTestCasesCount(testCasesCount);
			userStoriesList.add(userStoryDetails);
		}
		return userStoriesList;
	}

	
	/**
	 * Method retrieves a details about a user story
	 * @param userStoryID
	 * @return
	 */
	@RequestMapping("userStoryDetail")
	public String retrieveUserStory(@RequestParam(value="userStoryID") String userStoryID){
		return "Retrieving the user Story ID for the user Story ID" + userStoryID;
	}

	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/testcases")
	public @ResponseBody HashMap<String, List<String>> searchForTestCases(){
		
		GitHubService gitService = new GitHubServiceImpl();
		HashMap<String, List<String>>  results= gitService.testCases("test");
		List<String> testCases = new ArrayList<String>();
		for(String key:results.keySet()){
			testCases.addAll(results.get(key));
		}
//		gitService.testCases();
		return results;
	}
}
