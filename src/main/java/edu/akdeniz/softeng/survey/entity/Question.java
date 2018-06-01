package edu.akdeniz.softeng.survey.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document
public class Question {

    public enum QuestionType {
        SINGLE_ANSWER, MULTI_ANSWER, NONE
    }

    private String questionText;
    private String questionType;

    private List<Answer> answerList;

    public Question() {
        answerList = new ArrayList<>();
    }


    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public QuestionType getQuestionType() {
        if (questionType == null) {
            return QuestionType.NONE;
        }
        return QuestionType.valueOf(questionType);
    }


    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType.name();
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(Collection<Answer> answerList) {
        this.answerList = new ArrayList<Answer>(answerList);
    }
}
