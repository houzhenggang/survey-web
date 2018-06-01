
package edu.akdeniz.softeng.survey;

import edu.akdeniz.softeng.logging.LoggerWrapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class})

public class SurveyApplication {

    public static void main(String[] args) {
        // TODO : ...
        ConfigurableApplicationContext contx = SpringApplication.run(SurveyApplication.class, args);
    }

}
