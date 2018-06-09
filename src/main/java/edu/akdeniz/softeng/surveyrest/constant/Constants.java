package edu.akdeniz.softeng.surveyrest.constant;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author maemresen
 */
public class Constants {

    public static class API {

        // TODO : consider them
        public static final String SURVEY_CLEAR_SERVICE_URL = "/survey/clear";
        public static final String SURVEY_RESET_SERVICE_URL = "/survey/reset";

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