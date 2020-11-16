package com.example.prutest.controllers;

import com.example.prutest.entities.Employee;
import com.example.prutest.entities.ProductLine;
import com.google.gson.Gson;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
    @Tag(value = "Integration")
class EmployeeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private Gson gson = new Gson();
    private final Employee bestEmployee;

    {
        bestEmployee = new Employee();
        bestEmployee.setId((long) 3);
        bestEmployee.setFirstName("Saveliy");
        bestEmployee.setLastName("Siniy");
        bestEmployee.setEmail("siniysaveliy@gmail.com");
        bestEmployee.setPhone("+3 050 333-33-33");
        bestEmployee.setOfficeCode(3);
        bestEmployee.setReportsTo(1);
        bestEmployee.setJobTitle("sales representative");
    }

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
                .andExpect(content().string(containsString(gson.toJson(bestEmployee))));
    }

    @Test
    @Transactional
    void addEmployee() throws Exception {
        Employee employee = new Employee();
        employee.setFirstName("TestName");
        employee.setLastName("TestLastName");
        employee.setReportsTo(1);
        employee.setJobTitle("sales representative");
        employee.setOfficeCode(1);
        employee.setPhone("+38 050 1234567");
        employee.setEmail("test@gmail.com");

        String json = gson.toJson(employee);
        this.mockMvc.perform(
                post("/employee/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void getAllEmployeesTest() throws Exception {
        mockMvc.perform(get("/employee/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(gson.toJson(bestEmployee))));
    }

    @Test
    void findEmployeesByOfficeCodeAndJobTitle() throws Exception {
        mockMvc.perform(get("/employee/findBy/officeCode/3/and/jobTitle/sales representative"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString(gson.toJson(bestEmployee))));
    }
}