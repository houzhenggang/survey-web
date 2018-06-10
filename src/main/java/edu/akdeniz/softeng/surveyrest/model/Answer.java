package edu.akdeniz.softeng.surveyrest.model;

import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;

public class Answer {

    private final Choice choice;
    private final boolean selected;

    public Answer(Choice choice, boolean selected) {
        this.choice = choice;
        this.selected = selected;
    }

    public Choice getChoice() {
        return choice;
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "choice=" + choice +
                ", selected=" + selected +
                '}';
    }
}
