package edu.akdeniz.softeng.surveyrest.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/*




 */

@Document
public class Answer {

    private String id;
    private String content;

    public Answer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
