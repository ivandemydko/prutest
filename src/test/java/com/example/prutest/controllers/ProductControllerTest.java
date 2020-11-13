package com.example.prutest.controllers;

import com.example.prutest.entities.ProductLine;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
//@Sql(value = "/productLines-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
//@Sql(value = "/productLines-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void productLines() throws Exception {
        mockMvc.perform(get("/product/productLine/all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().string(containsString("hats")));
    }

    @Test
    void addProductLine() throws Exception {
        this.mockMvc.perform(post("/product/productLine/add")
                .param("description", "socks"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateProductLine() throws Exception {
        this.mockMvc.perform(put("/product/productLine/update")
                .param("oldDescription", "new shoes")
                .param("newDescription", "shoes"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void deleteProductLine() throws Exception {
        this.mockMvc.perform(delete("/product/productLine/delete")
                .param("description", "underwears"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void addProductLineWithBody() throws Exception {
        Gson gson = new Gson();
        ProductLine productLine = new ProductLine();
        productLine.setDescription("body");
        String json = gson.toJson(productLine);
        this.mockMvc.perform(
                post("/product/productLine/addWithBody")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}