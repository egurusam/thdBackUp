
package dashboard.to;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "kind",
    "name",
    "version",
    "iteration_length",
    "week_start_day",
    "point_scale",
    "point_scale_is_custom",
    "bugs_and_chores_are_estimatable",
    "automatic_planning",
    "enable_tasks",
    "time_zone",
    "velocity_averaged_over",
    "number_of_done_iterations_to_show",
    "has_google_domain",
    "description",
    "enable_incoming_emails",
    "initial_velocity",
    "public",
    "atom_enabled",
    "project_type",
    "start_date",
    "start_time",
    "created_at",
    "updated_at",
    "account_id",
    "current_iteration_number",
    "enable_following"
})
public class PivotalProjects {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private Long version;
    @JsonProperty("iteration_length")
    private Long iterationLength;
    @JsonProperty("week_start_day")
    private String weekStartDay;
    @JsonProperty("point_scale")
    private String pointScale;
    @JsonProperty("point_scale_is_custom")
    private Boolean pointScaleIsCustom;
    @JsonProperty("bugs_and_chores_are_estimatable")
    private Boolean bugsAndChoresAreEstimatable;
    @JsonProperty("automatic_planning")
    private Boolean automaticPlanning;
    @JsonProperty("enable_tasks")
    private Boolean enableTasks;
    @JsonProperty("time_zone")
    private TimeZone timeZone;
    @JsonProperty("velocity_averaged_over")
    private Long velocityAveragedOver;
    @JsonProperty("number_of_done_iterations_to_show")
    private Long numberOfDoneIterationsToShow;
    @JsonProperty("has_google_domain")
    private Boolean hasGoogleDomain;
    @JsonProperty("description")
    private String description;
    @JsonProperty("enable_incoming_emails")
    private Boolean enableIncomingEmails;
    @JsonProperty("initial_velocity")
    private Long initialVelocity;
    @JsonProperty("public")
    private Boolean _public;
    @JsonProperty("atom_enabled")
    private Boolean atomEnabled;
    @JsonProperty("project_type")
    private String projectType;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("start_time")
    private String startTime;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("current_iteration_number")
    private Long currentIterationNumber;
    @JsonProperty("enable_following")
    private Boolean enableFollowing;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("version")
    public Long getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(Long version) {
        this.version = version;
    }

    @JsonProperty("iteration_length")
    public Long getIterationLength() {
        return iterationLength;
    }

    @JsonProperty("iteration_length")
    public void setIterationLength(Long iterationLength) {
        this.iterationLength = iterationLength;
    }

    @JsonProperty("week_start_day")
    public String getWeekStartDay() {
        return weekStartDay;
    }

    @JsonProperty("week_start_day")
    public void setWeekStartDay(String weekStartDay) {
        this.weekStartDay = weekStartDay;
    }

    @JsonProperty("point_scale")
    public String getPointScale() {
        return pointScale;
    }

    @JsonProperty("point_scale")
    public void setPointScale(String pointScale) {
        this.pointScale = pointScale;
    }

    @JsonProperty("point_scale_is_custom")
    public Boolean getPointScaleIsCustom() {
        return pointScaleIsCustom;
    }

    @JsonProperty("point_scale_is_custom")
    public void setPointScaleIsCustom(Boolean pointScaleIsCustom) {
        this.pointScaleIsCustom = pointScaleIsCustom;
    }

    @JsonProperty("bugs_and_chores_are_estimatable")
    public Boolean getBugsAndChoresAreEstimatable() {
        return bugsAndChoresAreEstimatable;
    }

    @JsonProperty("bugs_and_chores_are_estimatable")
    public void setBugsAndChoresAreEstimatable(Boolean bugsAndChoresAreEstimatable) {
        this.bugsAndChoresAreEstimatable = bugsAndChoresAreEstimatable;
    }

    @JsonProperty("automatic_planning")
    public Boolean getAutomaticPlanning() {
        return automaticPlanning;
    }

    @JsonProperty("automatic_planning")
    public void setAutomaticPlanning(Boolean automaticPlanning) {
        this.automaticPlanning = automaticPlanning;
    }

    @JsonProperty("enable_tasks")
    public Boolean getEnableTasks() {
        return enableTasks;
    }

    @JsonProperty("enable_tasks")
    public void setEnableTasks(Boolean enableTasks) {
        this.enableTasks = enableTasks;
    }

    @JsonProperty("time_zone")
    public TimeZone getTimeZone() {
        return timeZone;
    }

    @JsonProperty("time_zone")
    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @JsonProperty("velocity_averaged_over")
    public Long getVelocityAveragedOver() {
        return velocityAveragedOver;
    }

    @JsonProperty("velocity_averaged_over")
    public void setVelocityAveragedOver(Long velocityAveragedOver) {
        this.velocityAveragedOver = velocityAveragedOver;
    }

    @JsonProperty("number_of_done_iterations_to_show")
    public Long getNumberOfDoneIterationsToShow() {
        return numberOfDoneIterationsToShow;
    }

    @JsonProperty("number_of_done_iterations_to_show")
    public void setNumberOfDoneIterationsToShow(Long numberOfDoneIterationsToShow) {
        this.numberOfDoneIterationsToShow = numberOfDoneIterationsToShow;
    }

    @JsonProperty("has_google_domain")
    public Boolean getHasGoogleDomain() {
        return hasGoogleDomain;
    }

    @JsonProperty("has_google_domain")
    public void setHasGoogleDomain(Boolean hasGoogleDomain) {
        this.hasGoogleDomain = hasGoogleDomain;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("enable_incoming_emails")
    public Boolean getEnableIncomingEmails() {
        return enableIncomingEmails;
    }

    @JsonProperty("enable_incoming_emails")
    public void setEnableIncomingEmails(Boolean enableIncomingEmails) {
        this.enableIncomingEmails = enableIncomingEmails;
    }

    @JsonProperty("initial_velocity")
    public Long getInitialVelocity() {
        return initialVelocity;
    }

    @JsonProperty("initial_velocity")
    public void setInitialVelocity(Long initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    @JsonProperty("public")
    public Boolean getPublic() {
        return _public;
    }

    @JsonProperty("public")
    public void setPublic(Boolean _public) {
        this._public = _public;
    }

    @JsonProperty("atom_enabled")
    public Boolean getAtomEnabled() {
        return atomEnabled;
    }

    @JsonProperty("atom_enabled")
    public void setAtomEnabled(Boolean atomEnabled) {
        this.atomEnabled = atomEnabled;
    }

    @JsonProperty("project_type")
    public String getProjectType() {
        return projectType;
    }

    @JsonProperty("project_type")
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("start_time")
    public String getStartTime() {
        return startTime;
    }

    @JsonProperty("start_time")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
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

    @JsonProperty("account_id")
    public Long getAccountId() {
        return accountId;
    }

    @JsonProperty("account_id")
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("current_iteration_number")
    public Long getCurrentIterationNumber() {
        return currentIterationNumber;
    }

    @JsonProperty("current_iteration_number")
    public void setCurrentIterationNumber(Long currentIterationNumber) {
        this.currentIterationNumber = currentIterationNumber;
    }

    @JsonProperty("enable_following")
    public Boolean getEnableFollowing() {
        return enableFollowing;
    }

    @JsonProperty("enable_following")
    public void setEnableFollowing(Boolean enableFollowing) {
        this.enableFollowing = enableFollowing;
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
