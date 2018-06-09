package edu.akdeniz.softeng.surveyrest.entity;


/**
 * @author maemresen
 * <p>
 * Model to store answer of user for one question at on survey
 */
public class Result {

    /**
     * uid of the user who gives answer
     */
    private String userId;

    /**
     * which survey
     */
    private String surveyId;

    /**
     * which question
     */
    private String questionId;

    /**
     * which choice
     */
    private String answerId;

    /**
     * for open-ended questions
     */
    private String comment;


    public Result() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
