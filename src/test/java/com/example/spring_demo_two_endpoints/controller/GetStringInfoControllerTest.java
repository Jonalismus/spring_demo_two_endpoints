package com.example.spring_demo_two_endpoints.controller;

import org.junit.jupiter.api.Test;
import com.example.spring_demo_two_endpoints.service.StringInfo;
import com.example.spring_demo_two_endpoints.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GetStringInfoController.class)
class GetStringInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StringService stringService;

    @Test
    public void testGetStringInfo() throws Exception {
        StringInfo stringInfo = new StringInfo();
        stringInfo.setStoredString("Test String");
        stringInfo.setNumericOnly(false);
        stringInfo.setWhitespaceTupelsCount(2);

        when(stringService.getStringInfo()).thenReturn(stringInfo);

        mockMvc.perform(get("/api/getStringInfo")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.storedString").value("Test String"))
                .andExpect(jsonPath("$.numericOnly").value(false))
                .andExpect(jsonPath("$.whitespaceTupelsCount").value(2));
    }

}