package edu.akdeniz.softeng.surveyrest.entity;

import com.maemresen.jutils.helper.DateTimeHelper;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author maemresen
 * <p>
 * Model to store answer of user for one question at on survey
 */
@Document
public class Result {

    /**
     * uid represents taking survey action
     * Each answer given to a question during taking the survey has same uid
     */
    private String uid;


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
    private String choiceId;

    /**
     * for open-ended questions
     */
    private String comment;

    private String date;


    public Result() {
    date = DateTimeHelper.getTheDateInString(DateTimeHelper.DateFormat.MYSQL, DateTimeHelper.getCurrentDay());
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public String getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(String choiceId) {
        this.choiceId = choiceId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Result{" +
                "userId='" + userId + '\'' +
                ", surveyId='" + surveyId + '\'' +
                ", questionId='" + questionId + '\'' +
                ", choiceId='" + choiceId + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
