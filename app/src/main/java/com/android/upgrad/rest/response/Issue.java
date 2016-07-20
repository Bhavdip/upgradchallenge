package com.android.upgrad.rest.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "url",
        "repository_url",
        "labels_url",
        "comments_url",
        "events_url",
        "html_url",
        "id",
        "number",
        "title",
        "user",
        "labels",
        "state",
        "locked",
        "assignee",
        "assignees",
        "milestone",
        "comments",
        "created_at",
        "updated_at",
        "closed_at",
        "body"
})
public class Issue {

    @JsonProperty("url")
    private String url;
    @JsonProperty("repository_url")
    private String repositoryUrl;
    @JsonProperty("labels_url")
    private String labelsUrl;
    @JsonProperty("comments_url")
    private String commentsUrl;
    @JsonProperty("events_url")
    private String eventsUrl;
    @JsonProperty("html_url")
    private String htmlUrl;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("number")
    private Integer number;
    @JsonProperty("title")
    private String title;
    @JsonProperty("user")
    private User user;
    @JsonProperty("labels")
    private List<Object> labels = new ArrayList<>();
    @JsonProperty("state")
    private String state;
    @JsonProperty("locked")
    private Boolean locked;
    @JsonProperty("assignee")
    private Object assignee;
    @JsonProperty("assignees")
    private List<Object> assignees = new ArrayList<>();
    @JsonProperty("milestone")
    private Object milestone;
    @JsonProperty("comments")
    private Integer comments;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("closed_at")
    private Object closedAt;
    @JsonProperty("body")
    private String body;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * @return The url
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The repositoryUrl
     */
    @JsonProperty("repository_url")
    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    /**
     * @param repositoryUrl The repository_url
     */
    @JsonProperty("repository_url")
    public void setRepositoryUrl(String repositoryUrl) {
        this.repositoryUrl = repositoryUrl;
    }

    /**
     * @return The labelsUrl
     */
    @JsonProperty("labels_url")
    public String getLabelsUrl() {
        return labelsUrl;
    }

    /**
     * @param labelsUrl The labels_url
     */
    @JsonProperty("labels_url")
    public void setLabelsUrl(String labelsUrl) {
        this.labelsUrl = labelsUrl;
    }

    /**
     * @return The commentsUrl
     */
    @JsonProperty("comments_url")
    public String getCommentsUrl() {
        return commentsUrl;
    }

    /**
     * @param commentsUrl The comments_url
     */
    @JsonProperty("comments_url")
    public void setCommentsUrl(String commentsUrl) {
        this.commentsUrl = commentsUrl;
    }

    /**
     * @return The eventsUrl
     */
    @JsonProperty("events_url")
    public String getEventsUrl() {
        return eventsUrl;
    }

    /**
     * @param eventsUrl The events_url
     */
    @JsonProperty("events_url")
    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    /**
     * @return The htmlUrl
     */
    @JsonProperty("html_url")
    public String getHtmlUrl() {
        return htmlUrl;
    }

    /**
     * @param htmlUrl The html_url
     */
    @JsonProperty("html_url")
    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }

    /**
     * @return The id
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * @param id The id
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return The number
     */
    @JsonProperty("number")
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number The number
     */
    @JsonProperty("number")
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return The title
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The user
     */
    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    /**
     * @param user The user
     */
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * @return The labels
     */
    @JsonProperty("labels")
    public List<Object> getLabels() {
        return labels;
    }

    /**
     * @param labels The labels
     */
    @JsonProperty("labels")
    public void setLabels(List<Object> labels) {
        this.labels = labels;
    }

    /**
     * @return The state
     */
    @JsonProperty("state")
    public String getState() {
        return state;
    }

    /**
     * @param state The state
     */
    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return The locked
     */
    @JsonProperty("locked")
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked The locked
     */
    @JsonProperty("locked")
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    /**
     * @return The assignee
     */
    @JsonProperty("assignee")
    public Object getAssignee() {
        return assignee;
    }

    /**
     * @param assignee The assignee
     */
    @JsonProperty("assignee")
    public void setAssignee(Object assignee) {
        this.assignee = assignee;
    }

    /**
     * @return The assignees
     */
    @JsonProperty("assignees")
    public List<Object> getAssignees() {
        return assignees;
    }

    /**
     * @param assignees The assignees
     */
    @JsonProperty("assignees")
    public void setAssignees(List<Object> assignees) {
        this.assignees = assignees;
    }

    /**
     * @return The milestone
     */
    @JsonProperty("milestone")
    public Object getMilestone() {
        return milestone;
    }

    /**
     * @param milestone The milestone
     */
    @JsonProperty("milestone")
    public void setMilestone(Object milestone) {
        this.milestone = milestone;
    }

    /**
     * @return The comments
     */
    @JsonProperty("comments")
    public Integer getComments() {
        return comments;
    }

    /**
     * @param comments The comments
     */
    @JsonProperty("comments")
    public void setComments(Integer comments) {
        this.comments = comments;
    }

    /**
     * @return The createdAt
     */
    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt The created_at
     */
    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return The updatedAt
     */
    @JsonProperty("updated_at")
    public String getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt The updated_at
     */
    @JsonProperty("updated_at")
    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return The closedAt
     */
    @JsonProperty("closed_at")
    public Object getClosedAt() {
        return closedAt;
    }

    /**
     * @param closedAt The closed_at
     */
    @JsonProperty("closed_at")
    public void setClosedAt(Object closedAt) {
        this.closedAt = closedAt;
    }

    /**
     * @return The body
     */
    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    /**
     * @param body The body
     */
    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
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
