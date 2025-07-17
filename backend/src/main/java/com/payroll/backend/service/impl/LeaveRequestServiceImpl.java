package com.payroll.backend.service.impl;

import com.payroll.backend.dto.LeaveRequestDTO;
import com.payroll.backend.dto.request.LeaveRequestRequestDTO;
import com.payroll.backend.entity.Employees;
import com.payroll.backend.entity.LeaveRequest;
import com.payroll.backend.repository.EmployeesRepository;
import com.payroll.backend.repository.LeaveRequestRepository;
import com.payroll.backend.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private EmployeesRepository employeeRepository;

    private LeaveRequestDTO convertToDTO(LeaveRequest leave) {
        String employeeName = leave.getEmployee().getFirstName();
        String approvedByName = leave.getApprovedBy() != null ? leave.getApprovedBy().getFirstName() : null;

        return new LeaveRequestDTO(
                leave.getLeaveId(),
                leave.getEmployee().getEmployeeId(),
                employeeName,
                leave.getFromDate(),
                leave.getToDate(),
                leave.getReason(),
                leave.getStatus(),
                leave.getSubmittedOn(),
                leave.getApprovedBy() != null ? leave.getApprovedBy().getEmployeeId() : null,
                approvedByName
        );
    }

    @Override
    public List<LeaveRequestDTO> getAllLeaveRequests() {
        return leaveRequestRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LeaveRequestDTO getLeaveRequestById(Long leaveId) {
        LeaveRequest leave = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found with id: " + leaveId));
        return convertToDTO(leave);
    }

    @Override
    public LeaveRequestDTO createLeaveRequest(LeaveRequestRequestDTO requestDTO) {
        Employees employee = employeeRepository.findById(requestDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + requestDTO.getEmployeeId()));

        LeaveRequest leave = new LeaveRequest();
        leave.setEmployee(employee);
        leave.setFromDate(requestDTO.getFromDate());
        leave.setToDate(requestDTO.getToDate());
        leave.setReason(requestDTO.getReason());
        leave.setStatus(requestDTO.getStatus());
        leave.setSubmittedOn(requestDTO.getSubmittedOn());

        if (requestDTO.getApprovedBy() != null) {
            Employees approver = employeeRepository.findById(requestDTO.getApprovedBy())
                    .orElseThrow(() -> new RuntimeException("Approver not found with ID: " + requestDTO.getApprovedBy()));
            leave.setApprovedBy(approver);
        }

        return convertToDTO(leaveRequestRepository.save(leave));
    }

    @Override
    public LeaveRequestDTO updateLeaveRequest(Long leaveId, LeaveRequestRequestDTO requestDTO) {
        LeaveRequest leave = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found with id: " + leaveId));

        Employees employee = employeeRepository.findById(requestDTO.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + requestDTO.getEmployeeId()));

        leave.setEmployee(employee);
        leave.setFromDate(requestDTO.getFromDate());
        leave.setToDate(requestDTO.getToDate());
        leave.setReason(requestDTO.getReason());
        leave.setStatus(requestDTO.getStatus());
        leave.setSubmittedOn(requestDTO.getSubmittedOn());

        if (requestDTO.getApprovedBy() != null) {
            Employees approver = employeeRepository.findById(requestDTO.getApprovedBy())
                    .orElseThrow(() -> new RuntimeException("Approver not found with ID: " + requestDTO.getApprovedBy()));
            leave.setApprovedBy(approver);
        } else {
            leave.setApprovedBy(null);
        }

        return convertToDTO(leaveRequestRepository.save(leave));
    }

    @Override
    public void deleteLeaveRequest(Long leaveId) {
        LeaveRequest leave = leaveRequestRepository.findById(leaveId)
                .orElseThrow(() -> new RuntimeException("Leave not found with id: " + leaveId));
        leaveRequestRepository.delete(leave);
    }
    
    public List<LeaveRequest> getAllLeavesForEmployee(Long empId) {
        return leaveRequestRepository.findByEmployee_EmployeeId(empId);
    }
}

