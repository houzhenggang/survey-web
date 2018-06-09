package edu.akdeniz.softeng.surveyrest.constant;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author maemresen
 */
public class Constants {

    public static class API {

        // TODO : consider them
        public static final String SURVEY_LIST_SERVICE_URL = "/survey/list";
        public static final String SURVEY_CREATE_SERVICE_URL = "/survey/create";
        public static final String SURVEY_SAVE_SERVICE_URL = "/survey/save";
        public static final String SURVEY_SHOW_SERVICE_URL = "/survey/show";

    }

    // ...
    public static final String ERROR_URI = "/error";

    /* API Credentials */
    public static class Credentials {
        public static final String USER_NAME = "admin";
        public static final String USER_PASS = "pass";
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