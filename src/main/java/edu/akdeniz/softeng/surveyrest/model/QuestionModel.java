package edu.akdeniz.softeng.surveyrest.model;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;

import java.util.List;

public class QuestionModel {

    private final Question question;
    private final List<Answer> answerList;
    private final String comment;

    public QuestionModel(Question question, String comment) {
        this(question, NotNullList.emptyList(), comment);
    }

    public QuestionModel(Question question, List<Answer> answerList) {
        this(question, answerList, "");
    }

    public QuestionModel(Question question, List<Answer> answerList, String comment) {
        this.question = question;
        this.answerList = new NotNullList<>(answerList);
        this.comment = comment;
    }


    public Question getQuestion() {
        return question;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "question=" + question +
                ", answerList=" + answerList +
                ", comment='" + comment + '\'' +
                '}';
    }
}
