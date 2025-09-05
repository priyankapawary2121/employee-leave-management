package com.employee.leave.repository;


import com.employee.leave.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepo extends MongoRepository<Employee,String> {

    Optional<Employee> findByEmail(String email);
    Optional<Employee>findByCode(String code);
}
