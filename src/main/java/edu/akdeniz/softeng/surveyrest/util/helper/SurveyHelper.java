package edu.akdeniz.softeng.surveyrest.util.helper;

import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.entity.survey.Answer;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.ResultService;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.ResultManipulationService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.SurveyManipulationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * @author maemresen
 *
 * Component consist of helper funtions
 * reset all data, clear all data etc.
 */
@Component
public class SurveyHelper {

    private final SurveyService surveyService;
    private final SurveyManipulationService surveyManipulationService;

    private final ResultService resultService;
    private final ResultManipulationService resultManipulationService;

    @Autowired
    public SurveyHelper(SurveyService surveyService, SurveyManipulationService surveyManipulationService, ResultService resultService, ResultManipulationService resultManipulationService) {
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
        return surveyService.getSurveyList();
    }

    public List<Survey> resetDB() {

        clearDB();

        // setting survey 1...
        Survey survey = new Survey();
        survey.setTitle("Survey Title");
        survey.setDescription("Survey Description");

        // setting question 1...
        Question q1 = new Question();
        q1.setType("singleLine");
        q1.setTitle("Would you like to add something?");
        q1.setHint("it could be better, if...");

        // setting answers ...
        Answer a1 = new Answer();
        a1.setContent("Answer 1");

        Answer a2 = new Answer();
        a2.setContent("Answer 2");

        // setting question 2...
        Question q2 = new Question();
        q2.setType("multiline");
        q2.setTitle("Other Questions");
        q2.setHint("it could be better, if...");
        q2.setChoices(Arrays.asList(a1, a2));

        survey.setQuestions(Arrays.asList(q1, q2));
        surveyManipulationService.save(survey);

        survey = new Survey();
        survey.setTitle("Survey Title 2");
        survey.setDescription("Survey Description 2");
        survey.setQuestions(Collections.singletonList(q2));
        surveyManipulationService.save(survey);


        // printing out...
        ConsoleHelper.startSection("Survey List");
        System.out.println(JsonHelper.objectToJson(surveyService.getSurveyList()));
        return surveyService.getSurveyList();
    }


}
