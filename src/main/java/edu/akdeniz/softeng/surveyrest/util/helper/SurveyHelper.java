package edu.akdeniz.softeng.surveyrest.util.helper;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.akdeniz.softeng.surveyrest.controller.ManipulationController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.maemresen.jutils.helper.ConsoleHelper;

import edu.akdeniz.softeng.surveyrest.constant.Constants;
import edu.akdeniz.softeng.surveyrest.entity.survey.Choice;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.ResultService;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.ResultManipulationService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.SurveyManipulationService;

/**
 * @author maemresen
 * <p>
 * Component consist of helper funtions reset all data, clear all data
 * etc.
 */
@Component
public class SurveyHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(SurveyHelper.class.getName());

    private final SurveyService surveyService;
    private final SurveyManipulationService surveyManipulationService;

    private final ResultService resultService;
    private final ResultManipulationService resultManipulationService;

    @Autowired
    public SurveyHelper(SurveyService surveyService, SurveyManipulationService surveyManipulationService,
                        ResultService resultService, ResultManipulationService resultManipulationService) {
        this.surveyService = surveyService;
        this.surveyManipulationService = surveyManipulationService;
        this.resultService = resultService;
        this.resultManipulationService = resultManipulationService;
    }

    public Survey getDummySurvey() {
        Survey temp = new Survey();
        temp.setTitle("DummySurvey1");
        temp.setDescription("DummyDescription1");
        return temp;
    }

    public List<Survey> clearDB() {
        surveyManipulationService.deleteAll();
        resultManipulationService.deleteAll();
        LOGGER.info("Survey Database cleared.");
        return surveyService.getSurveyList();
    }

    public List<Survey> resetDB() {

        clearDB();

        // setting answers ...
        Choice a1 = new Choice();
        a1.setContent("Choice 1");

        Choice a2 = new Choice();
        a2.setContent("Choice 2");

        Choice a3 = new Choice();
        a3.setContent("Choice 3");

        Choice a4 = new Choice();
        a4.setContent("Choice 4");

        // setting question 1...
        Question q1 = new Question();
        q1.setType(Constants.QuestionType.SINGLE_CHOICE);
        q1.setTitle("Would you like to add something?");
        q1.setHint("it could be better, if...");
        q1.setChoices(Arrays.asList(a1, a2));

        // setting question 2...
        Question q2 = new Question();
        q2.setType(Constants.QuestionType.SINGLE_CHOICE);
        q2.setTitle("Other Questions");
        q2.setHint("it could be better, if...");
        q2.setChoices(Arrays.asList(a3, a4));

        // setting question 3...

        // setting survey 1...
        Survey survey = new Survey();
        survey.setTitle("Survey Title");
        survey.setDescription("Survey Description");
        survey.setQuestions(Arrays.asList(q1, q2));
        surveyManipulationService.save(survey);

        // setting survey 2...
        survey = new Survey();
        survey.setTitle("Survey Title 2");
        survey.setDescription("Survey Description 2");
        survey.setQuestions(Collections.singletonList(q2));
        surveyManipulationService.save(survey);

        LOGGER.info("Survey Database was reset.");
        // printing out...
        //ConsoleHelper.startSection("Survey List");
        //System.out.println(JsonHelper.objectToJson(surveyService.getSurveyList()));
        return surveyService.getSurveyList();
    }
}
