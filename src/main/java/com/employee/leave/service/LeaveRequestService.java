package com.employee.leave.service;

import com.employee.leave.model.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {

    LeaveRequest apply(String employeeId,LeaveRequest request);
    List<LeaveRequest> listOfEmployee(String employeeId);
}
