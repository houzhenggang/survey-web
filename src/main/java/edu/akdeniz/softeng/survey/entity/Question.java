package edu.akdeniz.softeng.survey.entity;

import org.springframework.data.annotation.Id;

public class Question {

    public enum QuestionType {
        SINGLE_ANSWER, MULTI_ANSWER
    }

    @Id
    private int questionId;
    private int surveyId;
    private String questionText;
    private QuestionType questionType;

}
