package edu.akdeniz.softeng.survey.entity;

import org.springframework.data.annotation.Id;

public class Answer {

    @Id
    private int answerId;
    private int questionId;
    private String answerText;
}
