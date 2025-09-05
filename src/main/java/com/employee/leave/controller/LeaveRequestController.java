package com.employee.leave.controller;

import com.employee.leave.dto.LeaveRequestDto;
import com.employee.leave.model.LeaveRequest;
import com.employee.leave.service.LeaveRequestService;
import jakarta.validation.Valid;
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
    public ResponseEntity<LeaveRequest> apply(@PathVariable String employeeId, @Valid @RequestBody LeaveRequestDto dto)
    {
        LeaveRequest request = new LeaveRequest();
        request.setEmployeeId(employeeId);
        request.setStartDate(dto.getStartDate());
        request.setEndDate(dto.getEndDate());
        request.setReason(dto.getReason());
        return ResponseEntity.ok(leaveRequestService.apply(employeeId,request));
    }

    @GetMapping("/get/{employeeId}")
    public ResponseEntity<List<LeaveRequest>> listOfEmployee(@PathVariable String employeeId)
    {
        List<LeaveRequest> list = leaveRequestService.listOfEmployee(employeeId);
        return list.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(list);
    }

    @PutMapping("/{requestId}/decision")
    public ResponseEntity<LeaveRequest> approveOrReject(@PathVariable String requestId,
                                                        @RequestParam String managerId,
                                                        @RequestParam boolean approve,
                                                        @RequestParam(required=false) String comments){

        return ResponseEntity.ok(leaveRequestService.approveOrReject(requestId,managerId,approve,comments));











    }
}
