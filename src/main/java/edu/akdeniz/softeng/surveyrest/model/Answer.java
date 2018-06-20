package edu.akdeniz.softeng.surveyrest.model;

import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;

public class Answer {

    private final Choice choice;
    private final boolean selected;
    private final int count;

    public Answer(Choice choice, boolean selected, int count) {
        this.choice = choice;
        this.selected = selected;
        this.count = count;
    }


    public Choice getChoice() {
        return choice;
    }

    public boolean isSelected() {
        return selected;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "choice=" + choice +
                ", selected=" + selected +
                '}';
    }
}
