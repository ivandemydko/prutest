package com.example.prutest.services;

import com.example.prutest.entities.Employee;
import com.example.prutest.mappers.EmployeesMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private EmployeesMapper employeesMapper;

    public List<HashMap<String, Object>> getTopFiveNamesOfEmployeesAndProfit() {
        List<HashMap<String, Object>> list = employeesMapper.getTopFiveNamesOfEmployeesAndProfit();
        log.info(String.valueOf(list));
        return list;
    }

    public void addEmployee(Employee employee) {
        employeesMapper.addEmployee(employee);
    }
}
