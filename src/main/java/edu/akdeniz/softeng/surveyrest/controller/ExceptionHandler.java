package edu.akdeniz.softeng.surveyrest.controller;

import edu.akdeniz.softeng.surveyrest.constant.Constants;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class ExceptionHandler implements ErrorController {

    @RequestMapping(value = Constants.ERROR_URI)
    private String error(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by
        // Spring.
        // Here we just define response body.

        /**/
        switch (response.getStatus()) {

            // not found
            case 404:
                return "404";
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return Constants.ERROR_URI;
    }
}