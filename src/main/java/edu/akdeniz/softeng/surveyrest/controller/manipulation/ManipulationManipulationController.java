package edu.akdeniz.softeng.surveyrest.controller.manipulation;

import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.service.manipulation.SurveyManipulationService;
import edu.akdeniz.softeng.surveyrest.util.helper.SurveyHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/secure")
public class ManipulationManipulationController {

    private final SurveyHelper surveyHelper;
    private final SurveyManipulationService surveyManipulationService;

    @Autowired
    public ManipulationManipulationController(SurveyHelper surveyHelper, SurveyManipulationService surveyManipulationService) {
        this.surveyHelper = surveyHelper;
        this.surveyManipulationService = surveyManipulationService;
    }

    /* Secured */

    @PostMapping("/survey/create")
    public String create(@ModelAttribute("survey") Survey survey) {
        return "redirect:/secure/survey/" + surveyManipulationService.create(survey);
    }

    @PostMapping("/survey/save")
    public String save(@ModelAttribute("survey") Survey survey) {
        return "redirect:/secure/survey/" + surveyManipulationService.save(survey) + "/edit";
    }

    @ResponseBody
    @GetMapping("/survey/clear")
    public List<Survey> clearDB() {
        return surveyHelper.clearDB();
    }

    @ResponseBody
    @GetMapping("/survey/reset")
    public List<Survey> resetDB() {
        return surveyHelper.resetDB();
    }

}