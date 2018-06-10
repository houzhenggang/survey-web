package edu.akdeniz.softeng.surveyrest.entity;

import com.maemresen.jutils.collections.NotNullList;

import java.util.List;


/**
 * @author maemresen
 * <p>
 * Model sotres answers of the user.
 */
public class SurveyResult {


    /**
     * results of user
     */
    private List<Result> results;

    public SurveyResult() {
        results = new NotNullList<>();
    }


    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = new NotNullList<>(results);
    }

    @Override
    public String toString() {
        return "SurveyResult{" +
                ", results=" + results +
                '}';
    }
}
