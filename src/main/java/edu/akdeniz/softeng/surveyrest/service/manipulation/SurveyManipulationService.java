package edu.akdeniz.softeng.surveyrest.service.manipulation;

import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.util.helper.SecurityHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author maemresen
 * <p>
 * Manipulation Service to manipulate surveys.
 * creating, editing, deleting etc.
 */
@Controller
@RequestMapping("/service/manipulation")
public class SurveyManipulationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyManipulationService.class.getName());


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
        String surveyId = save(survey, false);
        LOGGER.info(String.format("Survey[%s] created by [%s]", surveyId, SecurityHelper.getUserName()));
        return surveyId;
    }

    /**
     * updates the given survey
     *
     * @param survey object will be updated
     * @return id of updated object
     */
    public String save(Survey survey) {
        return save(survey, true);
    }

    private String save(Survey survey, boolean print) {
        surveyRepo.save(survey);
        String surveyId = survey.getSurveyId();
        if (print) {
            LOGGER.info(String.format("Survey[%s] saved by [%s]", surveyId, SecurityHelper.getUserName()));
        }
        return surveyId;
    }

    /**
     * deletes the given survey
     *
     * @param survey object will be deleted
     */
    public void delete(Survey survey) {
        surveyRepo.delete(survey);
        LOGGER.info(String.format("Survey[%s] deleted by [%s]", survey.getSurveyId(), SecurityHelper.getUserName()));
    }

    /**
     * delete all surveys on database
     */
    public void deleteAll() {
        surveyRepo.deleteAll();
        LOGGER.info(String.format("All surveys deleted by [%s]", SecurityHelper.getUserName()));
    }


}
