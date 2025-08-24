package com.employee.leave.controller;

import com.employee.leave.model.LeaveRequest;
import com.employee.leave.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leaves")
public class LeaveRequestController {

    @Autowired
    LeaveRequestService leaveRequestService;

    @PostMapping("/{employeeId}")
    public ResponseEntity<LeaveRequest> apply(@PathVariable String employeeId, @RequestBody LeaveRequest request)
    {
        return ResponseEntity.ok(leaveRequestService.apply(employeeId,request));
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<List<LeaveRequest>> listOfEmployee(@PathVariable String employeeId)
    {
        List<LeaveRequest> list = leaveRequestService.listOfEmployee(employeeId);
        return list.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(list);
    }
}
