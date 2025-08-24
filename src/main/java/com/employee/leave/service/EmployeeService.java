package com.employee.leave.service;

import com.employee.leave.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employee);

    public List<Employee> getEmployees();

}
