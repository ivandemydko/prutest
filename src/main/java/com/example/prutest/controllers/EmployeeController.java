package com.example.prutest.controllers;

import com.example.prutest.entities.Employee;
import com.example.prutest.services.EmployeeService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("employee")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @GetMapping("/topFive")
    @ApiOperation(value = "Finds names of top 5 employees who made the most sales" +
            " and amount for which each employee sold",
            response = List.class)
    public List<HashMap<String, Object>> getTopFiveNamesOfEmployeesAndProfit() {
        return employeeService.getTopFiveNamesOfEmployeesAndProfit();
    }

    @PostMapping("/add")
    public void addEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }
}