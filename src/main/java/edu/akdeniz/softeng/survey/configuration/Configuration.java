package edu.akdeniz.softeng.survey.configuration;

public abstract class Configuration {


    public enum DatabaseType {
        MEMORY, LOCAL, PROD
    }


    public abstract DatabaseType getDatabase();

}
