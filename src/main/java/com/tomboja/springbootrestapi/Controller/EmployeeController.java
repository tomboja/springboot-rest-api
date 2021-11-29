package com.tomboja.springbootrestapi.Controller;

import com.tomboja.springbootrestapi.Model.Employee;
import com.tomboja.springbootrestapi.Service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 11/28/21
 */

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Rest APIs follow from here

    @PostMapping()
    // Using ResponseEntity here: because we can add complete response
    // information like status and headers into it
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // Get all employees from the db
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // Build GET employee by id restApi
    // eg. http://localhost:8080/api/employees/1
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
        return new ResponseEntity<Employee>(
                employeeService.getEmployeeById(id),
                HttpStatus.OK);
    }

    // Build UPDATE employee by id restApi
    // eg. http://localhost:8080/api/employees/1
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("id") long id, @RequestBody Employee employee) {
        // @RequestBody helps to convert JSON object to from request body to java object
        return new ResponseEntity<Employee>(
                employeeService.updateEmployee(employee, id), HttpStatus.OK);
    }

    // Build delete Employee RestApi
    // eg. http://localhost:8080/api/employees/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }
}
