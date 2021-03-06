package edu.akdeniz.softeng.surveyrest.entity.survey;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.maemresen.jutils.collections.NotNullList;
import com.maemresen.jutils.helper.DateTimeHelper;

import edu.akdeniz.softeng.surveyrest.constant.Constants.QuestionType;

/**
 * @author maemresen
 */
@Document
public class Question {

	@Id
	private String id = UUID.randomUUID().toString();

	/**
	 * type of question, open-ended, multi-choice etc.
	 */
	private String type;

	/**
	 * title of the question
	 */
	private String title;

	/**
	 * hint to answer, not necessary
	 */
	private String hint;

	/**
	 * creation date of question
	 */
	private Date createDate;

	/**
	 * choices of the question
	 */
	private List<Choice> choices;

	public Question() {
		choices = new NotNullList<>();
		createDate = DateTimeHelper.getCurrentDay();
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public QuestionType getTypeEnum() {
		return QuestionType.SINGLE_CHOICE;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setType(QuestionType type) {
		setType(type.name());
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public String getCreateDate() {
		return DateTimeHelper.getTheDateInString(DateTimeHelper.DateFormat.MYSQL, createDate);
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = new NotNullList<>(choices);
	}

	/**
	 * @return is question open-ended or not
	 */

	@SuppressWarnings("unused")
	// TODO : DO NOT DELETE. JSP files are using
	public boolean single() {
		// return getTypeEnum() == QuestionType.OPEN_ENDED;
		return false;
	}

	@Override
	public String toString() {
		return "Question{" + "id='" + id + '\'' + ", type='" + type + '\'' + ", title='" + title + '\'' + ", hint='"
				+ hint + '\'' + ", createDate=" + createDate + ", choices=" + choices + '}';
	}
}
