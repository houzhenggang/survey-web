package edu.akdeniz.softeng.surveyrest.config;


import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.akdeniz.softeng.surveyrest.util.helper.SecurityHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements
        AuthenticationSuccessHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException {
        String referrer = request.getHeader("referer");
        log.info(String.format("Login User with Username=[%s]", SecurityHelper.getUserName()));
        System.out.println(referrer);
        response.sendRedirect("/surveys");
    }
}

