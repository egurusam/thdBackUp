
package dashboard.to;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "id",
    "created_at",
    "updated_at",
    "accepted_at",
    "story_type",
    "name",
    "description",
    "current_state",
    "requested_by_id",
    "url",
    "project_id",
    "owner_ids",
    "labels",
    "owned_by_id"
})
public class PivotalUserStory {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("accepted_at")
    private String acceptedAt;
    @JsonProperty("story_type")
    private String storyType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("current_state")
    private String currentState;
    @JsonProperty("requested_by_id")
    private Integer requestedById;
    @JsonProperty("url")
    private String url;
    @JsonProperty("project_id")
    private Integer projectId;
    @JsonProperty("owner_ids")
    private List<Integer> ownerIds = null;
    @JsonProperty("labels")
    private List<Label> labels = null;
    @JsonProperty("owned_by_id")
    private Integer ownedById;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @JsonProperty("accepted_at")
    public String getAcceptedAt() {
        return acceptedAt;
    }

    @JsonProperty("accepted_at")
    public void setAcceptedAt(String acceptedAt) {
        this.acceptedAt = acceptedAt;
    }

    @JsonProperty("story_type")
    public String getStoryType() {
        return storyType;
    }

    @JsonProperty("story_type")
    public void setStoryType(String storyType) {
        this.storyType = storyType;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("current_state")
    public String getCurrentState() {
        return currentState;
    }

    @JsonProperty("current_state")
    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    @JsonProperty("requested_by_id")
    public Integer getRequestedById() {
        return requestedById;
    }

    @JsonProperty("requested_by_id")
    public void setRequestedById(Integer requestedById) {
        this.requestedById = requestedById;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("project_id")
    public Integer getProjectId() {
        return projectId;
    }

    @JsonProperty("project_id")
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @JsonProperty("owner_ids")
    public List<Integer> getOwnerIds() {
        return ownerIds;
    }

    @JsonProperty("owner_ids")
    public void setOwnerIds(List<Integer> ownerIds) {
        this.ownerIds = ownerIds;
    }

    @JsonProperty("labels")
    public List<Label> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @JsonProperty("owned_by_id")
    public Integer getOwnedById() {
        return ownedById;
    }

    @JsonProperty("owned_by_id")
    public void setOwnedById(Integer ownedById) {
        this.ownedById = ownedById;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
