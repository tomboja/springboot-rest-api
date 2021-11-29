package com.tomboja.springbootrestapi.Service.Impl;

import com.tomboja.springbootrestapi.Exception.ResourceNotFoundException;
import com.tomboja.springbootrestapi.Model.Employee;
import com.tomboja.springbootrestapi.Repository.EmployeeRepository;
import com.tomboja.springbootrestapi.Service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 11/28/21
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // If we have only one constructor here, we don't need to add
    // @Autowired cas spring takes care of it
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
//        Optional<Employee> employee = Optional.of(employeeRepository.getById(id));
//        if (employee.isPresent()) {
//            return employee.get();
//        } else  {
//            throw new ResourceNotFoundException("Employee", "Id", id);
//        }

        return employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        // First check if the employee with given id is available in db
        Employee existingEmployee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        // If found, set the new data from the employee to the existing employee
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        // Save the updated employee
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {
        // check whether the employee with id exists in the db
        employeeRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        // If it doesn't throw exception, employee exists and the following will be executed
        employeeRepository.deleteById(id);
    }
}
