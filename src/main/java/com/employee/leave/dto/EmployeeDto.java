package com.employee.leave.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmployeeDto {

    @NotBlank (message = "employee code is required")
    String code;

    @NotBlank(message = "name is required")
    @Size(min=2,max = 50,message = "name must be between 2- 50 characters")
    String name;

    @Email(message = "Invalid Email address")
    String email;

    @NotBlank (message = "Department code is required")
    String department;


    public @NotBlank(message = "employee code is required") String getCode() {
        return code;
    }

    public @NotBlank(message = "name is required") @Size(min = 2, max = 50, message = "name must be between 2- 50 characters") String getName() {
        return name;
    }

    public @Email(message = "Invalid Email address") String getEmail() {
        return email;
    }

    public @NotBlank(message = "Department code is required") String getDepartment() {
        return department;
    }


    public void setCode(@NotBlank(message = "employee code is required") String code) {
        this.code = code;
    }

    public void setName(@NotBlank(message = "name is required") @Size(min = 2, max = 50, message = "name must be between 2- 50 characters") String name) {
        this.name = name;
    }

    public void setEmail(@Email(message = "Invalid Email address") String email) {
        this.email = email;
    }

    public void setDepartment(@NotBlank(message = "Department code is required") String department) {
        this.department = department;
    }


}
