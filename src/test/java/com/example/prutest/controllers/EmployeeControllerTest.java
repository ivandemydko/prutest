package com.example.prutest.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.containsString;



@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
//@Sql(value = "/create-employee-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = "/create-employee-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class EmployeeControllerTest {

    private final String bestEmployee = "{\"id\":3,\"firstName\":\"Saveliy\",\"lastName\":\"Siniy\",\"" +
            "email\":\"siniysaveliy@gmail.com\",\"phone\":\"+3 050 333-33-33\",\"officeCode\":3,\"reportsTo\":1," +
            "\"jobTitle\":\"sales representative\"}";


    @Autowired
    private MockMvc mockMvc;


    @Test
    void getTopFiveNamesOfEmployeesAndProfit() throws Exception {
        mockMvc.perform(get("/employee/topFive"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

    @Test
    void getTopFiveEmployees() throws Exception {
        mockMvc.perform(get("/employee/top/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(bestEmployee)));
    }

    @Test
    void addEmployee() {
    }


    @Test
    void getAllEmployeesTest() throws Exception {
        mockMvc.perform(get("/employee/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(bestEmployee)));
    }

    @Test
    void findEmployeesByOfficeCodeAndJobTitle() throws Exception {
        mockMvc.perform(get("/employee/findBy/officeCode/3/and/jobTitle/sales representative"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(bestEmployee)));
    }
}