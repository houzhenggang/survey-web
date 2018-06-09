package edu.akdeniz.softeng.surveyrest.service.manipulation;

import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SurveyManipulationService {

    private final SurveyRepo surveyRepo;

    @Autowired
    public SurveyManipulationService(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    // ....
    public String create(Survey survey) {
        return save(survey);
    }

    public String save(Survey survey) {
        surveyRepo.save(survey);
        return survey.getSurveyId();
    }

    public void delete(Survey survey) {
        surveyRepo.delete(survey);
    }

    public void deleteAll() {
        surveyRepo.deleteAll();
    }
}
