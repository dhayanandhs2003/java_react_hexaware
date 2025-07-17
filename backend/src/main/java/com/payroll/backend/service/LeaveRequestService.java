package com.payroll.backend.service;

import com.payroll.backend.dto.LeaveRequestDTO;
import com.payroll.backend.dto.request.LeaveRequestRequestDTO;
import com.payroll.backend.entity.LeaveRequest;

import java.util.List;

public interface LeaveRequestService {
    List<LeaveRequestDTO> getAllLeaveRequests();
    LeaveRequestDTO getLeaveRequestById(Long leaveId);
    LeaveRequestDTO createLeaveRequest(LeaveRequestRequestDTO requestDTO);
    LeaveRequestDTO updateLeaveRequest(Long leaveId, LeaveRequestRequestDTO requestDTO);
    void deleteLeaveRequest(Long leaveId);
    List<LeaveRequest> getAllLeavesForEmployee(Long employeeId);
}

