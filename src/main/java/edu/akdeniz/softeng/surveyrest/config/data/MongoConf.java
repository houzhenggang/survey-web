package edu.akdeniz.softeng.surveyrest.config.data;


import com.mongodb.MongoClient;

import edu.akdeniz.softeng.surveyrest.constant.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class MongoConf extends AbstractMongoConfiguration {
    @Override
    public MongoClient mongoClient() {
        return new MongoClient(Constants.DATABASE_HOST, Constants.DATABASE_PORT);
    }

    @Override
    protected String getDatabaseName() {
        return Constants.DATABASE_NAME;
    }
}
