package com.tomboja.springbootrestapi.Service;

import com.tomboja.springbootrestapi.Model.Employee;

import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 11/28/21
 */

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    void deleteEmployee(long id);
}
