package edu.akdeniz.softeng.surveyrest.util.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author maemresen
 *
 * Helper class to convert ojbect to JSON
 */
public class JsonHelper {


    public static <T> String objectToJson(T object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "";
        }
    }
}
