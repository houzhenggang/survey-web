package edu.akdeniz.softeng.survey.controller;


import edu.akdeniz.softeng.logging.LoggerWrapper;
import edu.akdeniz.softeng.survey.SurveyApplication;
import edu.akdeniz.softeng.survey.constant.Constants.SurveyPageURL;
import edu.akdeniz.softeng.survey.constant.Enums;
import edu.akdeniz.softeng.survey.entity.Survey;
import edu.akdeniz.softeng.survey.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author maemresen
 */

@Controller
public class HomeController {

    /**/
    @GetMapping(SurveyPageURL.HOME_PAGE_URI)
    public String home(Model model, @RequestParam("name") String name) {


        LoggerWrapper wrapper = new LoggerWrapper(HomeController.class);
        wrapper.info("Hi From " + name);


        return Enums.Page.HOME.getPageName();
    }
}