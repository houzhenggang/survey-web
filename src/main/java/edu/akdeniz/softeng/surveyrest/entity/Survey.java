package edu.akdeniz.softeng.surveyrest.entity;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.DateTimeHelper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


@Document
public class Survey {

    @Id
    private String surveyId;
    private String title;
    private String description;
    private List<Question> questions;
    private Date createDate;
    private List<String> order;

    public Survey() {
        this.createDate = DateTimeHelper.getCurrentDay();
        this.questions = new NotNullList<>();
        this.order = new NotNullList<>();
    }

    public String getSurveyId() {
        return surveyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = new NotNullList<>(questions);
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = new NotNullList<>(order);
    }

    @Override
    public String toString() {
        return getTitle() + " with id=[" + getSurveyId() + "]";
    }
}
