package com.employee.leave.controller;

import com.employee.leave.model.Employee;
import com.employee.leave.service.EmployeeService;
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
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee e) {
        return new ResponseEntity<>(employeeService.createEmployee(e), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.OK);
    }

}

