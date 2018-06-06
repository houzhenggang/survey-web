package edu.akdeniz.softeng.surveyrest;

import com.maemresen.jutils.helper.ConsoleHelper;
import edu.akdeniz.softeng.surveyrest.constant.Constants;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class APITest {

    @Autowired
    private MockMvc mockMvc;

    //"http://localhost:7100"

    @Test
    @Ignore
    public void SurveyListAPITest() throws Exception {
        resultActions(this.mockMvc.perform(getBuilder(Constants.API.SURVEY_LIST_SERVICE_URL)));
    }

    @Test
    public void SurveyCreateAPITest() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("surveyId", "5b17b81ea8027c31ccb494d3");
        resultActions(this.mockMvc.perform(getBuilder(Constants.API.SURVEY_SHOW_SERVICE_URL, params)));
    }

    /* Helper */
    private void resultActions(ResultActions resultActions) throws Exception {
        resultActions.andExpect(MockMvcResultMatchers.status()
                .isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    // ....
    private MockHttpServletRequestBuilder getBuilder(String url) {
        return getBuilder(url, new LinkedMultiValueMap<>());
    }

    private MockHttpServletRequestBuilder getBuilder(String url, MultiValueMap<String, String> params) {
        return MockMvcRequestBuilders.get(url).with(httpBasic(Constants.Credentials.USER_NAME, Constants.Credentials.USER_PASS))
                .params(params)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8");
    }

}