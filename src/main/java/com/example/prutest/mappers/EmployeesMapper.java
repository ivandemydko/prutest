package com.example.prutest.mappers;

import com.example.prutest.entities.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface EmployeesMapper {

    List<HashMap<String, Object>> getTopFiveNamesOfEmployeesAndProfit();

    List<Employee> getTopEmployees(@Param("limit") int limit);

    void addEmployee(Employee employee);

    List<Employee> getAllEmployees();

    List<Employee> findEmployeesByOfficeCodeAndJobTitle(@Param("officeCode") int officeCode, @Param("jobTitle") String jobTitle);
}
