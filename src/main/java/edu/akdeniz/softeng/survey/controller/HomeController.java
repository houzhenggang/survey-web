package edu.akdeniz.softeng.survey.controller;

import edu.akdeniz.softeng.survey.constant.Constants;
import edu.akdeniz.softeng.survey.constant.Enums;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author maemresen
 */

@Controller
public class HomeController {

    /**/
    @GetMapping(Constants.SurveyPageURL.HOME_PAGE_URI)
    public String home() {
        return Enums.Page.HOME.getPageName();
    }
}