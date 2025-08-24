package com.employee.leave.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="employees")
public class Employee {

    @JsonProperty("code")
    String code;

    @JsonProperty("name")
     String name;

    @JsonProperty("email")
     String email;

    @JsonProperty("department")
     String department;

    @JsonProperty("leaveBalance")
     int leaveBalance;

    public String getEmail() {
        return email;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
}
