package edu.akdeniz.softeng.surveyrest.service;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.entity.survey.Answer;
import edu.akdeniz.softeng.surveyrest.entity.survey.Question;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.repository.AnswerRepo;
import edu.akdeniz.softeng.surveyrest.repository.QuestionRepo;
import edu.akdeniz.softeng.surveyrest.repository.ResultRepo;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import edu.akdeniz.softeng.surveyrest.util.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class SurveyService {

    private final SurveyRepo surveyRepo;

    private final ResultRepo resultRepo;

    @Autowired
    public SurveyService(ResultRepo resultRepo, SurveyRepo surveyRepo) {
        this.resultRepo = resultRepo;
        this.surveyRepo = surveyRepo;
    }


    public Survey getDummySurvey() {
        Survey temp = new Survey();
        temp.setTitle("DummySurvey1");
        temp.setDescription("DummyDescription1");
        return temp;
    }


    public List<Survey> clearDB() {
        surveyRepo.deleteAll();
        resultRepo.deleteAll();
        return surveyRepo.findAll();
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
        save(survey);

        for (Question q : survey.getQuestions()) {

            Result result = new Result();
            result.setUserId("user1");
            result.setSurveyId(survey.getSurveyId());
            result.setQuestionId(q.getId());

            // getting answer id
            int cc = q.getChoices().size();
            if (cc < 1) {
                result.setComment("my comment");
            } else {
                Random rand = new Random();
                Answer a = q.getChoices().get(rand.nextInt(cc));
                result.setAnswerId(a.getId());
            }
            resultRepo.save(result);
        }

        // printing out...
        ConsoleHelper.startSection("Survey List");
        System.out.println(JsonHelper.objectToJson(surveyRepo.findAll()));

        ConsoleHelper.startSection("Result List");
        System.out.println(JsonHelper.objectToJson(resultRepo.findAll()));

        return surveyRepo.findAll();
    }


    public List<Survey> getSurveyList() {
        return new NotNullList<>(surveyRepo.findAll());
    }

    public List<Result> getResultList() {
        return new NotNullList<Result>(resultRepo.findAll());
    }

    // .......................................

    // TODO : no need

    public String create() {
        // TODO : parameters? returns what?
        return "create";
    }


    public Survey save(Survey survey) {
        surveyRepo.save(survey);
        return survey;
    }

    public Survey show(String id) {
        return surveyRepo.findById(id).orElse(null);
    }

    public void delete(Survey survey) {
        surveyRepo.delete(survey);
    }

    // TODO : take survey ??

    // TODO : delete survey ??

    // TODO : edit survey??

}
