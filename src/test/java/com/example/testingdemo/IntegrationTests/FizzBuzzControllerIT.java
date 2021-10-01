package com.example.testingdemo.IntegrationTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class FizzBuzzControllerIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Call FizzBuzz endpoint with a value should return correct answer")
    void test1() throws Exception {
       MvcResult result = mockMvc.perform( MockMvcRequestBuilders
               .get("/fizzbuzz/30")
               .accept(MediaType.APPLICATION_JSON))
           .andDo(print())
           .andExpect(status().isOk())
           .andReturn();

        assertThat(result.getResponse().getContentAsString(), is("FizzBuzz"));
    }
}
