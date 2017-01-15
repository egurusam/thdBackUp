package dashboard.service;

import java.util.HashMap;
import java.util.List;

public interface GitHubService {

	public HashMap<String, List<String>> testCases(String fileName);
	
	
}
