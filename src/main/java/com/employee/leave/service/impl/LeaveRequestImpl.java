package com.employee.leave.service.impl;

import com.employee.leave.model.LeaveRequest;
import com.employee.leave.repository.LeaveRequestRepo;
import com.employee.leave.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestImpl implements LeaveRequestService {

    @Autowired
    LeaveRequestRepo leaveRequestRepo;

    @Override
    public LeaveRequest apply(String employeeId, LeaveRequest request) {
        request.setId(null);
        request.setEmployeeId(employeeId);
        request.setStatus("PENDING");
        return leaveRequestRepo.save(request);
    }

    @Override
    public List<LeaveRequest> listOfEmployee(String employeeId) {
        return leaveRequestRepo.findByEmployeeId(employeeId);
    }
}
