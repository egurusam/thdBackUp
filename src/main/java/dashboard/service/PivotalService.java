package dashboard.service;

import java.util.List;

import dashboard.to.PivotalProjects;
import dashboard.to.PivotalUserStory;
import dashboard.to.ProjectDetails;
import dashboard.to.UserStoryDetails;

public interface PivotalService {
	
	/*
	 * Retrieve projects for a user
	 */
	public List<ProjectDetails> retrieveProjects(String userName);
	
	public  PivotalProjects retrieveProject(Long projectID);
	
	public List<PivotalUserStory> retrieveUserStoriesDefault(String projectID);
	
	public List<PivotalUserStory> retrieveUserStoriesPaginated(String projectID, String offset,String limit);

	

}
