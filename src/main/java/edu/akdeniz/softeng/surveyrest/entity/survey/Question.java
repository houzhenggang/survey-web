package edu.akdeniz.softeng.surveyrest.entity.survey;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.DateTimeHelper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document
public class Question {

    @Id
    private String id = UUID.randomUUID().toString();
    private String type;
    private String title;
    private String hint;
    private Date createDate;
    private List<Answer> choices;


    public Question() {
        choices = new NotNullList<>();
        createDate = DateTimeHelper.getCurrentDay();
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public List<Answer> getChoices() {
        return choices;
    }


    public String getCreateDate() {
        return DateTimeHelper.getTheDateInString(DateTimeHelper.DateFormat.MYSQL, createDate);
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public void setChoices(List<Answer> choices) {
        this.choices = new NotNullList<>(choices);
    }

    public boolean single() {
        return false;
    }

}
