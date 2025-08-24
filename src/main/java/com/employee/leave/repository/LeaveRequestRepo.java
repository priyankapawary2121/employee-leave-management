package com.employee.leave.repository;

import com.employee.leave.model.LeaveRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LeaveRequestRepo extends MongoRepository<LeaveRequest,String> {

    List<LeaveRequest> findByEmployeeId(String employeeId);
}
