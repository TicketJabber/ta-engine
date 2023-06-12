package engine;

public class WeightRequest {
    private Double taskComplexity;
    private Integer estimatedTime;
    private Integer loggedTime;
    private Integer addedLines;
    private Integer removedLines;
    private Integer changedLines;
    private Integer numberOfComments;
    private Integer numberOfIterations;
    private Double shareholderFeedback;

    public Double getTaskComplexity() {
        return taskComplexity;
    }

    public void setTaskComplexity(Double taskComplexity) {
        this.taskComplexity = taskComplexity;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Integer getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(Integer loggedTime) {
        this.loggedTime = loggedTime;
    }

    public Integer getAddedLines() {
        return addedLines;
    }

    public void setAddedLines(Integer addedLines) {
        this.addedLines = addedLines;
    }

    public Integer getRemovedLines() {
        return removedLines;
    }

    public void setRemovedLines(Integer removedLines) {
        this.removedLines = removedLines;
    }

    public Integer getChangedLines() {
        return changedLines;
    }

    public void setChangedLines(Integer changedLines) {
        this.changedLines = changedLines;
    }

    public Integer getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(Integer numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

    public Integer getNumberOfIterations() {
        return numberOfIterations;
    }

    public void setNumberOfIterations(Integer numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }

    public Double getShareholderFeedback() {
        return shareholderFeedback;
    }

    public void setShareholderFeedback(Double shareholderFeedback) {
        this.shareholderFeedback = shareholderFeedback;
    }
}
