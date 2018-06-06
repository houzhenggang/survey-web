package edu.akdeniz.softeng.surveyrest;

import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.constant.Constants;
import edu.akdeniz.softeng.surveyrest.controller.SurveyController;
import edu.akdeniz.softeng.surveyrest.entity.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MongoTest {

    @Autowired
    private SurveyService surveyService;

    @Test
    public void InsertTest() {
        ConsoleHelper.printAction(() -> {

            Survey survey = surveyService.getDummySurvey();
            // inserting
            surveyService.save(survey);
            System.out.println(survey + " saved successfully");
            listResults();

            // deleting
            ConsoleHelper.startSection("Deleting Dummy Content");
            surveyService.delete(survey);
            System.out.println(survey + " deleted successfully");
            listResults();

        }, "Insert Test");
    }

    private void listResults() {
        // listing
        ConsoleHelper.startSection("List Results");
        surveyService.getSurveyList().forEach(System.out::println);
    }

}