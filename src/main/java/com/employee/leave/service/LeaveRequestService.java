package com.employee.leave.service;

import com.employee.leave.model.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {

    LeaveRequest apply(String employeeId,LeaveRequest request) throws IllegalAccessException;
    List<LeaveRequest> listOfEmployee(String employeeId);
    LeaveRequest approveOrReject(String requestId,String mangerId,boolean approve, String comments);
}
