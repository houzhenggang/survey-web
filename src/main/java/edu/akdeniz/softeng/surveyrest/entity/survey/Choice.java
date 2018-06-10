package edu.akdeniz.softeng.surveyrest.entity.survey;

import com.maemresen.jutils.helper.DateTimeHelper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

/**
 * @author maemresen
 */
@Document
public class Choice {

    @Id
    private String id = UUID.randomUUID().toString();
    /**
     * choice text, e.g. "This is Choice"
     */
    private String content;

    /**
     * given answer, for open-ended questions
     */
    private String comment;

    /**
     * creation date of that answer
     */
    private Date createDate;

    public Choice() {
        createDate = DateTimeHelper.getCurrentDay();
    }

    public String getId() {
        return id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateDate() {
        return DateTimeHelper.getTheDateInString(DateTimeHelper.DateFormat.MYSQL, createDate);
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", comment='" + comment + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
