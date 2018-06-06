package edu.akdeniz.softeng.surveyrest.constant;


import edu.akdeniz.softeng.surveyrest.entity.Survey;
import edu.akdeniz.softeng.surveyrest.util.custom.CustomSurveyList;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maemresen
 */
public class Constants {

    public static class API {

        public static final String SURVEY_LIST_SERVICE_URL = "/survey/list";
        public static final String SURVEY_CREATE_SERVICE_URL = "/survey/create";
        public static final String SURVEY_SAVE_SERVICE_URL = "/survey/save";
        public static final String SURVEY_SHOW_SERVICE_URL = "/survey/show";

    }

    // ...
    public static final String ERROR_URI = "/error";

    /* API Credentials */
    public static class Credentials {
        public static final String USER_NAME = "sdfhleos";
        public static final String USER_PASS = "ed287b2e-4d84-4b1c-89c5-ae6bf320d092";
        public static final String ENCRYPTED_USER_PASS = getEncoder().encode(USER_PASS);
        /**
         * Credentials for rest-service and CBARest...
         */
        public final static String PLAIN_CREDS = String.format("%s:%s", USER_NAME, USER_PASS);


        private static PasswordEncoder getEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

}