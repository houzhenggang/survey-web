package edu.akdeniz.softeng.surveyrest.entity;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;

import java.util.List;

public class SurveyResult {

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
}
