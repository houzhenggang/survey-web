package edu.akdeniz.softeng.surveyrest.entity;

import com.maemresen.jutils.collections.NotNullList;

import java.util.List;


/**
 * @author maemresen
 * <p>
 * Model sotres answers of the user.
 */
public class SurveyResult {

    private String surveyId;

    /**
     * results of user
     */
    private List<Result> results;

    public SurveyResult() {
        results = new NotNullList<>();
    }

    public String getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(String surveyId) {
        this.surveyId = surveyId;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = new NotNullList<>(results);
    }
}
