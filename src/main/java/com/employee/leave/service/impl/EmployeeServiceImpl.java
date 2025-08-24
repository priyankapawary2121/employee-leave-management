package com.employee.leave.service.impl;

import com.employee.leave.model.Employee;
import com.employee.leave.repository.EmployeeRepo;
import com.employee.leave.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public Employee createEmployee(Employee employee) {

        employeeRepo.findByEmail(employee.getEmail()).ifPresent(employee1 -> {
            throw new RuntimeException("Email already exists:"+employee1.getEmail());
        });
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

}
