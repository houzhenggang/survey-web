package edu.akdeniz.softeng.surveyrest;

import edu.akdeniz.softeng.surveyrest.entity.Answer;
import edu.akdeniz.softeng.surveyrest.entity.Question;
import edu.akdeniz.softeng.surveyrest.entity.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@ContextConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    private final SurveyRepo repository;

    @Autowired
    public Test(SurveyRepo repository) {
        this.repository = repository;
    }

    @org.junit.Test
    public List<Survey> resetDB() {
        repository.deleteAll();

        Answer a1 = new Answer();
        a1.setAnswerText("a1");

        Answer a2 = new Answer();
        a2.setAnswerText("a2");


        Answer a3 = new Answer();
        a3.setAnswerText("a2");


        Answer a4 = new Answer();
        a4.setAnswerText("a2");

        Question q1 = new Question();
        q1.setQuestionText("q1");
        q1.setAnswerList(Arrays.asList(a1, a2));
        q1.setQuestionType(Question.QuestionType.MULTI_ANSWER);

        Question q2 = new Question();
        q2.setQuestionText("q2");
        q2.setAnswerList(Arrays.asList(a3, a4));
        q2.setQuestionType(Question.QuestionType.SINGLE_ANSWER);

        // save a couple of customers
        Survey survey;

        // ...
        survey = new Survey();
        survey.setSurveyDescription("Survey1");
        survey.setSurveyQuestions(Arrays.asList(q1, q2));
        repository.save(survey);

        // ...
        survey = new Survey();
        survey.setSurveyDescription("Survey2");
        survey.setSurveyQuestions(Arrays.asList(q1, q2));
        repository.save(survey);

        return repository.findAll();
    }
}