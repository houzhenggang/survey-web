package edu.akdeniz.softeng.surveyrest.constant;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author maemresen
 */
public class Constants {


    // ...

    /**
     * Error URI
     */
    public static final String ERROR_URI = "/error";

    /* API Credentials */

    /**
     * Credentials for sample user for testing
     */
    public static class Credentials {
        public static final String USER_NAME = "admin";
        public static final String USER_PASS = "pass";
        public static final String ENCRYPTED_USER_PASS = getEncoder().encode(USER_PASS);

        private static PasswordEncoder getEncoder() {
            return new BCryptPasswordEncoder();
        }
    }

    public enum QuestionType {
        OPEN_ENDED, SINGLE_CHOICE, MULTI_CHOICE
    }

}