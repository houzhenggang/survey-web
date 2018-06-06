package edu.akdeniz.softeng.surveyrest.entity;

import com.maemresen.jutils.helper.DateTimeHelper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Document
public class Survey {


    @Id
    private String surveyId;
    private String surveyTitle;
    private List<Question> surveyQuestions;
    private boolean isActive;
    private Date createDate;
    private String authorId;


    public Survey() {
        this.isActive = true;
        this.createDate = new Date();
        this.surveyQuestions = new ArrayList<>();
    }


    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public void setSurveyTitle(String surveyTitle) {
        this.surveyTitle = surveyTitle;
    }


    public List<Question> getSurveyQuestions() {
        return surveyQuestions;
    }

    public void setSurveyQuestions(List<Question> surveyQuestions) {
        this.surveyQuestions = new ArrayList<>(surveyQuestions);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public String getCreateDate() {
        return DateTimeHelper.getTheDateInString(DateTimeHelper.DateFormat.MYSQL, createDate);
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return getSurveyTitle() + " with id=[" + getSurveyId() + "]";
    }
}
