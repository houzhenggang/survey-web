package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.entity.Result;
import edu.akdeniz.softeng.surveyrest.entity.SurveyResult;
import edu.akdeniz.softeng.surveyrest.entity.survey.Survey;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import edu.akdeniz.softeng.surveyrest.util.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {


    @Autowired
    private SurveyService surveyService;

    //

    //

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        return "welcome";
    }

    @GetMapping("/surveys")
    public String surveys(Model model) {
        model.addAttribute("surveyList", surveyService.getSurveyList());
        return "surveys";
    }

    @GetMapping(value = {"/survey/{surveyId}", "/survey"})
    public String apply(Model model, @PathVariable(required = false) String surveyId) {
        if (surveyId == null) {
            return "redirect:/surveys";
        }
        model.addAttribute("survey", surveyService.show(surveyId));
        return "apply";
    }

    @ResponseBody
    @GetMapping("/survey/end")
    public SurveyResult end(@ModelAttribute("surveyResult") SurveyResult surveyResult) {
        for (Result r : surveyResult.getResults()) {
            //surveyService.save(r);
        }
        return surveyResult;
    }


    /* Secured */

    @GetMapping("/secure/survey/{surveyId}")
    public String edit(Model model, @PathVariable String surveyId) {
        model.addAttribute("survey", surveyService.show(surveyId));
        return "edit";
    }


    @GetMapping("/secure/survey/save")
    public String save(Model model, @ModelAttribute("survey") Survey survey) {
        surveyService.save(survey);
        return "redirect:/secure/survey/" + survey.getSurveyId();
    }


    /* Other */

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", SecurityHelper.getUserName());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good idea to show login screen again.
    }

}