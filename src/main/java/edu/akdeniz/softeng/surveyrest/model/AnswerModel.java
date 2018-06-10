package edu.akdeniz.softeng.surveyrest.model;

import edu.akdeniz.softeng.surveyrest.entity.survey.Answer;

public class AnswerModel {

    private final Answer answer;
    private final boolean selected;

    public AnswerModel(Answer answer, boolean selected) {
        this.answer = answer;
        this.selected = selected;
    }

    public Answer getAnswer() {
        return answer;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return "AnswerModel{" +
                "answer=" + answer +
                ", selected=" + selected +
                '}';
    }
}
