package edu.akdeniz.softeng.survey.controller;


import edu.akdeniz.softeng.survey.constant.Constants.SurveyPageURL;
import edu.akdeniz.softeng.survey.constant.Enums;
import edu.akdeniz.softeng.survey.entity.Survey;
import edu.akdeniz.softeng.survey.repository.SurveyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author maemresen
 */

@Controller
public class HomeController {

    /**/
    @GetMapping(SurveyPageURL.HOME_PAGE_URI)
    public String home(Model model) {


        return Enums.Page.HOME.getPageName();
    }
}