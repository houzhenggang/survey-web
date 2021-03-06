package edu.akdeniz.softeng.surveyrest.entity.survey;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.DateTimeHelper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;


/**
 * @author maemresen
 */
@Document
public class Survey {

    @Id
    private String surveyId;

    /**
     * title of the survey
     */
    private String title;

    /**
     * description of the survey
     */
    private String description;

    /**
     * creation date of the survey
     */
    private Date createDate;

    /**
     * questions of the survey
     */
    private List<Question> questions;


    public Survey() {
        this.questions = new NotNullList<>();
        this.createDate = DateTimeHelper.getCurrentDay();
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


    public String getCreateDate() {
        return DateTimeHelper.getTheDateInString(DateTimeHelper.DateFormat.MYSQL, createDate);
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = new NotNullList<>(questions);
    }


    @Override
    public String toString() {
        return "Survey{" +
                "surveyId='" + surveyId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", questions=" + questions +
                '}';
    }
}
