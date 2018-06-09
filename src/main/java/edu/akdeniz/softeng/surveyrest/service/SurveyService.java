package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author maemresen
 * <p>
 * Service for surveys.
 */
@Service
public class SurveyService {

    private final SurveyRepo surveyRepo;


    @Autowired
    public SurveyService(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    // ....
    public Survey getSurvey(String id) {
        return surveyRepo.findById(id).orElse(null);
    }

    public List<Survey> getSurveyList() {
        return new NotNullList<>(surveyRepo.findAll());
    }


}
