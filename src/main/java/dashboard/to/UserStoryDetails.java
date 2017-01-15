package dashboard.to;

import java.util.List;

public class UserStoryDetails {

	private String name;
	private int userStoryID;
	private String userStoryDescription;
	private String userStoryType;
	private List<String> labelName;
	private String status;
	private String testCasesURL;
	private List<String> testCases;
	private int testCasesCount;

	
	public int getTestCasesCount() {
		return testCasesCount;
	}

	public void setTestCasesCount(int testCasesCount) {
		this.testCasesCount = testCasesCount;
	}

	public String getUserStoryDescription() {
		return userStoryDescription;
	}

	public void setUserStoryDescription(String userStoryDescription) {
		this.userStoryDescription = userStoryDescription;
	}

	public String getUserStoryType() {
		return userStoryType;
	}

	public void setUserStoryType(String userStoryType) {
		this.userStoryType = userStoryType;
	}


	public List<String> getLabelName() {
		return labelName;
	}

	public void setLabelName(List<String> labelName) {
		this.labelName = labelName;
	}

	public void setUserStoryID(int userStoryID) {
		this.userStoryID = userStoryID;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUserStoryID() {
		return userStoryID;
	}

	public void setUserStoryID(Integer integer) {
		this.userStoryID = integer;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTestCasesURL() {
		return testCasesURL;
	}

	public void setTestCasesURL(String testCasesURL) {
		this.testCasesURL = testCasesURL;
	}

	public List<String> getTestCases() {
		return testCases;
	}

	public void setTestCases(List<String> testCases) {
		this.testCases = testCases;
	}
	

}
