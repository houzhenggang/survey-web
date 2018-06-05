package edu.akdeniz.softeng.surveyrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SurveyRestApp {
    public static void main(String[] args) {
        SpringApplication.run(SurveyRestApp.class, args);
    }
}
