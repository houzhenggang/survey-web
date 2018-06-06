package edu.akdeniz.softeng.surveyrest.entity;

import com.maemresen.jutils.collections.NotNullList;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document
public class Question {


    private String id;
    private String type;
    private String title;
    private String hint;
    private List<Answer> choices;

    public Question() {
        choices = new NotNullList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setChoices(List<Answer> choices) {
        this.choices = new NotNullList<>(choices);
    }
}
