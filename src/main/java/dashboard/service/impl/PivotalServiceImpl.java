package dashboard.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import dashboard.service.PivotalService;
import dashboard.to.PivotalProjects;
import dashboard.to.PivotalUserStory;
import dashboard.to.ProjectDetails;
import dashboard.util.DashboardUtil;

public class PivotalServiceImpl implements PivotalService {
	
	private static Logger logger = Logger.getLogger(PivotalServiceImpl.class);
	static String project_URL = "https://www.pivotaltracker.com/services/v5/projects";
	
	/**
	 * Retrieve all the active projects for the available user(token) 
	 * @
	 */
	public List<ProjectDetails> retrieveProjects(String userName){
		
		List<ProjectDetails> projectsList = new ArrayList<ProjectDetails>();
		logger.info("Inside Retrieve Projects");
		
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.set("X-TrackerToken", "8a8ad48fc1dd0e13b5f351ff16a0e35f");
	    HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);
	    
//		ProjectDetails[] projectDetails = restTemplate.getForObject("https://www.pivotaltracker.com/services/v5/projects", ProjectDetails[].class);
	    ResponseEntity<List<PivotalProjects>> response = restTemplate.exchange(project_URL,
	    		HttpMethod.GET,httpEntity,new ParameterizedTypeReference<List<PivotalProjects>>() {
	            });
	    logger.info("Status" +response.getStatusCode());
	    logger.info("Headers"+response.getHeaders());
	    logger.info("Inside Retrieve Projects"+response);
	    
	    for(PivotalProjects pivotalProject:response.getBody()){
	    	ProjectDetails projectDetails = new ProjectDetails();
	    	projectDetails.setProjectID(pivotalProject.getId().longValue());
	    	projectDetails.setProjectName(pivotalProject.getName());
	    	
	    	projectsList.add(projectDetails);
	    	
	    }
	    return projectsList;
	}
	
	/*
	 * Retrieve project details for a particular project based on the project ID
	 * @see dashboard.service.PivotalService#retrieveProject(java.lang.Long)
	 */
	public PivotalProjects retrieveProject(Long projectID){
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
	    headers.set("X-TrackerToken", "8a8ad48fc1dd0e13b5f351ff16a0e35f");
	    HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);
	    String url= project_URL+"/"+projectID;
	    ResponseEntity<PivotalProjects> response = restTemplate.exchange(url,
	    		HttpMethod.GET,httpEntity, PivotalProjects.class);
//	    PivotalProjects projectDetails = restTemplate.getForObject("https://www.pivotaltracker.com/services/v5/projects", PivotalProjects.class);
		return response.getBody();
	}
	
	
	/*
	 * Retrieve user stories for all projects for a user
	 * @see dashboard.service.PivotalService#retrieveProject(java.lang.Long)
	 */
	public List<PivotalUserStory> retrieveUserStoriesPaginated(String projectID,String offset, String limit){
		
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
		    headers.set("X-TrackerToken", "8a8ad48fc1dd0e13b5f351ff16a0e35f");
		    headers.set("offset",offset);
		    headers.set("limit",limit);
		    HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);
		    String url= project_URL+"/"+projectID+"/stories";
		    logger.info("URL "+ url);
		    ResponseEntity<List<PivotalUserStory>> response = restTemplate.exchange(url,
		    		HttpMethod.GET,httpEntity,new ParameterizedTypeReference<List<PivotalUserStory>>() {
		            });
			return response.getBody();
		}
	
	
	/*
	 * Retrieve all user stories for a project
	 * 
	 */
	public List<PivotalUserStory> retrieveUserStoriesDefault(String projectID){
		
			RestTemplate restTemplate = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
		    headers.set("X-TrackerToken", "8a8ad48fc1dd0e13b5f351ff16a0e35f");
		    HttpEntity<String> httpEntity = new HttpEntity<String>("parameters", headers);
		    String url= project_URL+"/"+projectID+"/stories";
		    logger.info("URL "+ url);
		    ResponseEntity<List<PivotalUserStory>> response = restTemplate.exchange(url,
		    		HttpMethod.GET,httpEntity,new ParameterizedTypeReference<List<PivotalUserStory>>() {
		            });
			return response.getBody();
		}
	
	
}

