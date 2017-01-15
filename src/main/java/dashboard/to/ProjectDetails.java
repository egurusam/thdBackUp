package dashboard.to;

import java.util.List;

public class ProjectDetails {

	private String projectName;
	
	public long getProjectID() {
		return projectID;
	}

	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}

	private long projectID;
	private List<UserStoryDetails> userStories;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public List<UserStoryDetails> getUserStories() {
		return userStories;
	}

	public void setUserStories(List<UserStoryDetails> userStories) {
		this.userStories = userStories;
	}
}
