package edu.akdeniz.softeng.surveyrest.entity;

public class Count {

    private int questionId;
    private int choiceId;
    private int count;


    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
