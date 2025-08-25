package com.employee.leave.controller;

import com.employee.leave.dto.EmployeeDto;
import com.employee.leave.model.Employee;
import com.employee.leave.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeDto dto) {

        Employee employee = new Employee();

        employee.setCode(dto.getCode());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setLeaveBalance(20);
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.OK);
    }

}

