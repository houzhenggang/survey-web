package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.constant.Constants;
import edu.akdeniz.softeng.surveyrest.service.SurveyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @author maemresen
 * <p>
 * Controller to handle exception.
 * E.g. 404, 502 etc.
 */
@Controller
public class ExceptionHandler implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandler.class.getName());


    @RequestMapping(value = Constants.ERROR_URI)
    private String error(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by
        // Spring.
        // Here we just define response body.

        /**/

        String originalUri = (String) request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);
        int status = response.getStatus();
        String msg = String.format("Error with Response=[%d], Request URI=[%s] and Session id=[%s]", status, originalUri, session.getId());
        LOGGER.error(msg);
        model.addAttribute("response", status);
        if (status == 404) {
            model.addAttribute("errMsg", originalUri + " not found");
        } else {
            model.addAttribute("errMsg", "An error occurred");
        }
        return "404";
    }

    @Override
    public String getErrorPath() {
        return Constants.ERROR_URI;
    }
}