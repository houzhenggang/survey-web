package edu.akdeniz.softeng.surveyrest.service.manipulation;

import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maemresen
 * <p>
 * Manipulation Service to manipulate surveys.
 * creating, editing, deleting etc.
 */
@Controller
@RequestMapping("/service/manipulation")
public class SurveyManipulationService {

    private final SurveyRepo surveyRepo;

    @Autowired
    public SurveyManipulationService(SurveyRepo surveyRepo) {
        this.surveyRepo = surveyRepo;
    }

    // ....

    /**
     * creates new survey
     *
     * @param survey object will be created
     * @return id of saved object
     */
    public String create(Survey survey) {
        return save(survey);
    }

    /**
     * updates the given survey
     *
     * @param survey object will be updated
     * @return id of updated object
     */
    public String save(Survey survey) {
        surveyRepo.save(survey);
        return survey.getSurveyId();
    }

    /**
     * deletes the given survey
     *
     * @param survey object will be deleted
     */
    public void delete(Survey survey) {
        surveyRepo.delete(survey);
    }

    /**
     * delete all surveys on database
     */
    public void deleteAll() {
        surveyRepo.deleteAll();
    }
}
