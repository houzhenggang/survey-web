package edu.akdeniz.softeng.survey;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author maemresen
 */
public class DateTimeHelper {


    public enum DateFormat {
        MYSQL(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        private SimpleDateFormat simpleDateFormat;

        DateFormat(SimpleDateFormat simpleDateFormat) {
            this.simpleDateFormat = simpleDateFormat;
        }
    }

    public static String getTheDateInString(DateFormat dateFormat, Date baseDate) {
        return getTheDateInString(baseDate, dateFormat.simpleDateFormat);
    }


    public static String getTheDateInString(Date baseDate, SimpleDateFormat simpleDateFormat) {
        if (baseDate == null) {
            return "";
        }
        return simpleDateFormat.format(baseDate);
    }

    /**/
    public static Date getTheDateInDate(String baseDate, DateFormat dateFormat) {
        return getTheDateInDate(baseDate, dateFormat.simpleDateFormat);
    }

    public static Date getTheDateInDate(String baseDate, SimpleDateFormat simpleDateFormat) {
        try {
            return simpleDateFormat.parse(baseDate);
        } catch (ParseException e) {
            return new Date();
        }
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