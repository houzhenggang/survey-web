package edu.akdeniz.softeng.survey.entity;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.DateTimeHelper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;
import java.util.Date;
import java.util.List;


@Document
public class Survey {


    @Id
    private String surveyId;
    private String name;
    private boolean active;
    private Date createDate;

    private List<Question> questionList;

    public Survey() {
        this.active = true;
        this.createDate = new Date();
        this.questionList = new NotNullList<>();
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
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

    public String getCreateDate() {
        return DateTimeHelper.getTheDateInString(createDate);
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(Collection<Question> questionList) {
        this.questionList = new NotNullList<>(questionList);
    }
}
