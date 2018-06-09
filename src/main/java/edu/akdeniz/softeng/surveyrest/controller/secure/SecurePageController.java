package edu.akdeniz.softeng.surveyrest.controller.secure;

import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure")
public class SecurePageController {


    private final SurveyService surveyService;

    @Autowired
    public SecurePageController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    /* Secured */

    @GetMapping("/survey/{surveyId}/edit")
    public String edit(Model model, @PathVariable String surveyId) {
        model.addAttribute("survey", surveyService.getSurvey(surveyId));
        return "edit";
    }

    @GetMapping("/survey/create")
    public String create() {
        return "create";
    }

}