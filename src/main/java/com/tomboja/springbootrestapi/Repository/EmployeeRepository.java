package com.tomboja.springbootrestapi.Repository;

import com.tomboja.springbootrestapi.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ProjectName: spring-boot-rest-api
 * @Author: tdessalegn
 * @Date: 11/28/21
 */

// No @Repository annotation needed here cos,
// JpaRepository takes care of that
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
