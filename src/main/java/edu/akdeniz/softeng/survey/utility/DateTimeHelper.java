package edu.akdeniz.softeng.survey.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author maemresen
 */
public class DateTimeHelper {

	private final static SimpleDateFormat mysqlDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Get the date as a string value...
	 * 
	 * @param baseDate
	 *            given date
	 * @return date in string format
	 */
	public static String getTheDateInString(Date baseDate) {

		if (baseDate == null)
			return "";

		String dateString = simpleDateFormat.format(baseDate);

		return dateString == null ? "" : dateString;
	}

	public static String getTheDateInMysqlString(Date baseDate) {

		if (baseDate == null)
			return "";

		String dateString = mysqlDateFormat.format(baseDate);

		return dateString == null ? "" : dateString;
	}

	public static Date getTheDateInDate(String baseDate) throws Exception {

		if (baseDate == null) {
			throw new Exception("Empty Date");
		}

		return simpleDateFormat.parse(baseDate);
	}

	/**/
	/**
	 * retrieve today
	 * 
	 * @return current day
	 */
	public static Date getCurrentDay() {
		return new Date();
	}

}