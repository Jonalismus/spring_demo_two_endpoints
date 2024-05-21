package com.example.spring_demo_two_endpoints.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StoreAndGetStringInfoIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testStoreAndGetStringInfo() throws Exception {
        String testString = "Test String";

        // first Endpoint: Store the string
        mockMvc.perform(post("/api/storeString")
                        .content(testString)
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());

        // second Endpoint: Retrieve the string information
        mockMvc.perform(get("/api/getStringInfo")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.storedString").value(testString))
                .andExpect(jsonPath("$.numericOnly").value(false))
                .andExpect(jsonPath("$.whitespaceTupelsCount").value(2));
    }

    @Test
    public void testStoreAndGetNumericStringInfo() throws Exception {
        String numericString = "12345";

        // first Endpoint: Store the numeric string
        mockMvc.perform(post("/api/storeString")
                        .content(numericString)
                        .contentType(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk());

        // second Endpoint: Retrieve the string information
        mockMvc.perform(get("/api/getStringInfo")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.storedString").value(numericString))
                .andExpect(jsonPath("$.numericOnly").value(true))
                .andExpect(jsonPath("$.whitespaceTupelsCount").value(1));
    }
}