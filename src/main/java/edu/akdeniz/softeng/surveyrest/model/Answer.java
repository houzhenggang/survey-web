package edu.akdeniz.softeng.surveyrest.model;

import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;

public class Answer {

    private final Choice choice;
    private final boolean selected;
    private final int count;
    private final double percentage;

    public Answer(Choice choice, boolean selected, int count, double percentage) {
        this.choice = choice;
        this.selected = selected;
        this.count = count;
        this.percentage = percentage;
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

    public double getPercentage() {
        return percentage;
    }


    public int getPercentageAsInt() {
        return ((int) (Math.round(percentage)));
    }


    @Override
    public String toString() {
        return "Answer{" +
                "choice=" + choice +
                ", selected=" + selected +
                '}';
    }
}
