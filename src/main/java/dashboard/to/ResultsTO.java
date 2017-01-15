package dashboard.to;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultsTO {

	@SerializedName("total_count")
	@Expose
	private Long totalCount;
	@SerializedName("incomplete_results")
	@Expose
	private Boolean incompleteResults;
	@SerializedName("items")
	@Expose
	private List<Item> items = null;

	public Long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	public Boolean getIncompleteResults() {
		return incompleteResults;
	}

	public void setIncompleteResults(Boolean incompleteResults) {
		this.incompleteResults = incompleteResults;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
