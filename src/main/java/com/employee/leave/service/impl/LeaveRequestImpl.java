package com.employee.leave.service.impl;

import com.employee.leave.exception.EmployeeNotFoundException;
import com.employee.leave.exception.InsufficientLeaveBalanceException;
import com.employee.leave.exception.LeaveRequestNotFoundException;
import com.employee.leave.model.Employee;
import com.employee.leave.model.LeaveRequest;
import com.employee.leave.repository.EmployeeRepo;
import com.employee.leave.repository.LeaveRequestRepo;
import com.employee.leave.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestImpl implements LeaveRequestService {

    @Autowired
    LeaveRequestRepo leaveRequestRepo;

    @Autowired
    EmployeeRepo employeeRepo;
    @Override
    public LeaveRequest apply(String employeeId, LeaveRequest request) throws IllegalAccessException {

        Employee employee = employeeRepo.findByCode(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found: " + employeeId));

        LocalDate start = request.getStartDate();
        LocalDate end = request.getEndDate();
        if(start==null||end==null||end.isBefore(start)) {
                throw  new IllegalAccessException("Illegal start end date");

        }
        List<LeaveRequest> existing = leaveRequestRepo.findByEmployeeId(employeeId);
        for(LeaveRequest lr : existing){
            if(lr.getStatus()==null)
                continue;
            String st=lr.getStatus().toUpperCase();
            if(!st.equals("REJECTED") && !st.equals("CANCELED")) {
                if (datesOverlap(start, end, lr.getStartDate(), lr.getEndDate())) {
                    throw new IllegalStateException("Overlapping leave exists with requestId: " + lr.getId());
                }
            }
        }
        request.setId(null);
        request.setEmployeeId(employeeId);
        request.setStatus("PENDING");
        return leaveRequestRepo.save(request);
    }

    private boolean datesOverlap(LocalDate s1, LocalDate e1, LocalDate s2, LocalDate e2) {
        if (s1 == null || e1 == null || s2 == null || e2 == null) return false;
        return !e1.isBefore(s2) && !e2.isBefore(s1);
    }


    @Override
    public List<LeaveRequest> listOfEmployee(String employeeId) {
        return leaveRequestRepo.findByEmployeeId(employeeId);
    }


    @Override
    public LeaveRequest approveOrReject(String requestId, String managerId, boolean approve, String comments) {
        LeaveRequest request = leaveRequestRepo.findById(requestId).orElseThrow(() ->
                new LeaveRequestNotFoundException("Leave request not found: " + requestId));


        Employee employee = employeeRepo.findByCode(request.getEmployeeId())
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found: " + request.getEmployeeId()));

        if (approve) {
            long days = ChronoUnit.DAYS.between(request.getStartDate(), request.getEndDate()) + 1;
            if (days <= 0) throw new IllegalArgumentException("Invalid leave duration");

            if (employee.getLeaveBalance() < days) {
                throw new InsufficientLeaveBalanceException("Insufficient leave balance. Required: " + days + ", Available: " + employee.getLeaveBalance());
            }

            employee.setLeaveBalance((int)(employee.getLeaveBalance() - days));
            request.setStatus("APPROVED");
            request.setApprovedBy(managerId);
            request.setManagerComments(comments);

            employeeRepo.save(employee); // persist change
            return leaveRequestRepo.save(request);
        } else {
            request.setStatus("REJECTED");
            request.setApprovedBy(managerId);
            request.setManagerComments(comments);
            return leaveRequestRepo.save(request);
        }
    }
}
