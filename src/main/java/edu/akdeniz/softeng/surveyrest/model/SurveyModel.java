package edu.akdeniz.softeng.surveyrest.model;

import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;

import java.util.List;

public class SurveyModel {

    private final Survey survey;
    private final List<QuestionModel> questionModelList;

    public SurveyModel(Survey survey, List<QuestionModel> questionModelList) {
        this.survey = survey;
        this.questionModelList = questionModelList;
    }

    public Survey getSurvey() {
        return survey;
    }

    public List<QuestionModel> getQuestionModelList() {
        return questionModelList;
    }

    @Override
    public String toString() {
        return "SurveyModel{" +
                "survey=" + survey +
                ", questionModelList=" + questionModelList +
                '}';
    }
}
