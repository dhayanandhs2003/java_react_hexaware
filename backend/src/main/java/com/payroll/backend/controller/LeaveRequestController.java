package com.payroll.backend.controller;

import com.payroll.backend.dto.LeaveRequestDTO;
import com.payroll.backend.dto.request.LeaveRequestRequestDTO;
import com.payroll.backend.entity.LeaveRequest;
import com.payroll.backend.service.LeaveRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @GetMapping
    public ResponseEntity<List<LeaveRequestDTO>> getAllLeaves() {
        return ResponseEntity.ok(leaveRequestService.getAllLeaveRequests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequestDTO> getLeaveById(@PathVariable Long id) {
        return ResponseEntity.ok(leaveRequestService.getLeaveRequestById(id));
    }

    @PostMapping
    public ResponseEntity<LeaveRequestDTO> createLeave(@RequestBody LeaveRequestRequestDTO dto) {
        return ResponseEntity.ok(leaveRequestService.createLeaveRequest(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequestDTO> updateLeave(@PathVariable Long id,
                                                       @RequestBody LeaveRequestRequestDTO dto) {
        return ResponseEntity.ok(leaveRequestService.updateLeaveRequest(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeave(@PathVariable Long id) {
        leaveRequestService.deleteLeaveRequest(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/employee/{empId}")
    public ResponseEntity<List<LeaveRequest>> getByEmployeeId(@PathVariable Long empId) {
        return ResponseEntity.ok(leaveRequestService.getAllLeavesForEmployee(empId));
    }
}
