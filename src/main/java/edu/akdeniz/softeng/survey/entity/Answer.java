package edu.akdeniz.softeng.survey.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Answer {

    private String answerText;

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
