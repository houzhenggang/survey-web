package edu.akdeniz.softeng.surveyrest.model;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;

import java.util.List;

public class QuestionModel {

    private final Question question;
    private final List<AnswerModel> answerModelList;

    public QuestionModel(Question question, List<AnswerModel> answerModelList) {
        this.question = question;
        this.answerModelList = new NotNullList<>(answerModelList);
    }


    public Question getQuestion() {
        return question;
    }

    public List<AnswerModel> getAnswerModelList() {
        return answerModelList;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "question=" + question +
                ", answerModelList=" + answerModelList +
                '}';
    }
}
