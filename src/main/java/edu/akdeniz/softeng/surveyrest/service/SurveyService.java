package edu.akdeniz.softeng.surveyrest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maemresen.jutils.collections.NotNullList;
import edu.akdeniz.softeng.surveyrest.entity.Answer;
import edu.akdeniz.softeng.surveyrest.entity.Question;
import edu.akdeniz.softeng.surveyrest.entity.Survey;
import edu.akdeniz.softeng.surveyrest.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class SurveyService {

    private final SurveyRepo repository;

    @Autowired
    public SurveyService(SurveyRepo repository) {
        this.repository = repository;
    }

    //survey list, create, save, show, delete, edit, update, takesurvey is created

    // {"_id": "q1", "type": "question",
    // "type": "multiplechoice", "question": "Best team?", "answers": ["Galatasaray", "Fenerbahçe", "Beşiktaş"]},

    public Survey getDummySurvey() {
        return new Survey();
    }


    public List<Survey> testDB() {
        repository.deleteAll();
        Survey survey = new Survey();
        survey.setTitle("Survey Title");
        survey.setDescription("Survey Description");

        Question q1 = new Question();
        q1.setType("singleLine");
        q1.setTitle("Would you like to add something?");
        q1.setHint("it could be better, if...");


        ObjectMapper mappr = new ObjectMapper();

        Question q2 = new Question();


        Question q3 = new Question();

        return repository.findAll();
    }


    public List<Survey> getSurveyList() {
        return new NotNullList<>(repository.findAll());
    }

    // .......................................

    // TODO : no need

    public String create() {
        // TODO : parameters? returns what?
        return "create";
    }


    public Survey save(Survey survey) {
        repository.save(survey);
        return survey;
    }

    public Survey show(String id) {
        return repository.findById(id).orElse(null);
    }

    public void delete(Survey survey) {
        repository.delete(survey);
    }

    // TODO : take survey ??

    // TODO : delete survey ??

    // TODO : edit survey??

}
