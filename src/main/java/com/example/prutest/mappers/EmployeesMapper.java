package com.example.prutest.mappers;

import com.example.prutest.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface EmployeesMapper {

    List<HashMap<String, Object>> getTopFiveNamesOfEmployeesAndProfit();

    List<Employee> getTopFiveEmployees();

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();
}
