package com.employee.leave.service.impl;

import com.employee.leave.model.LeaveRequest;
import com.employee.leave.repository.LeaveRequestRepo;
import com.employee.leave.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public LeaveRequest approveOrReject(String requestId, String mangerId, boolean approve, String comments) {
        LeaveRequest request = leaveRequestRepo.findById(requestId).orElseThrow(() -> new RuntimeException("Leave request not found: " + requestId));;

        request.setStatus(approve?"Approved":"Pending");
        request.setManagerComments(mangerId);
        request.setApprovedBy(comments);

        return leaveRequestRepo.save(request);
    }
}
