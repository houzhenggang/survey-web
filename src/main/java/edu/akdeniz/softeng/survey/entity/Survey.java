package edu.akdeniz.softeng.survey.entity;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Survey {

    @Id
    private int surveyId;
    private String name;
    private boolean active;
    private Date createDate;

    public Survey(){

    }

    public Survey(int surveyId, String name) {
        this.surveyId = surveyId;
        this.name = name;
        this.active = true;
        this.createDate = new Date();
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
