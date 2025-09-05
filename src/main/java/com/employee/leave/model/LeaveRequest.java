package com.employee.leave.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection="LeaveRequest")
public class LeaveRequest {
    @JsonProperty("id")
    @Id
    String id;

    @JsonProperty("employeeId")
    String employeeId;

    @JsonProperty("startDate")
    LocalDate startDate;

    @JsonProperty("endDate")
    LocalDate endDate;

    @JsonProperty("reason")
    String reason;

    @JsonProperty("status")
     String status;

    @JsonProperty("managerComments")
    String managerComments;

    @JsonProperty("approvedBy")
    String approvedBy;

    public String getId() {
        return id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public String getManagerComments() {
        return managerComments;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setManagerComments(String managerComments) {
        this.managerComments = managerComments;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
}
