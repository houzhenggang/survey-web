package edu.akdeniz.softeng.surveyrest;

import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.SurveyManipulationService;
import edu.akdeniz.softeng.surveyrest.util.helper.SurveyHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Mustafa Arif Şişman, Mustafa Fatih Baysan
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class MongoTest {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyHelper surveyHelper;

    @Autowired
    private SurveyManipulationService surveyManipulationService;

    @Test
    public void CRUDTest() {
        ConsoleHelper.printAction(() -> {
            Survey survey = surveyHelper.getDummySurvey();
            // inserting
            surveyManipulationService.save(survey);
            System.out.println(survey + " saved successfully");
            listResults();

            // update
            ConsoleHelper.startSection("Updating");
            survey.setTitle("UpdatedTitle");
            surveyManipulationService.save(survey);
            System.out.println(survey + " updated successfully");
            listResults();

            // deleting
            ConsoleHelper.startSection("Deleting Dummy Content");
            surveyManipulationService.delete(survey);
            System.out.println(survey + " deleted successfully");
            listResults();
        }, "CRUD Test");
    }


    // Helper
    private void listResults() {
        // listing
        ConsoleHelper.startSection("List Result");
        surveyService.getSurveyList().forEach(System.out::println);
    }

}