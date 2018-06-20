package edu.akdeniz.softeng.surveyrest.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "counts")
public class Counts {


    private String questionId;
    private String choiceId;
    private int count;


    public Counts() {

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Counts{" +
                "questionId='" + questionId + '\'' +
                ", choiceId='" + choiceId + '\'' +
                ", count=" + count +
                '}';
    }
}
