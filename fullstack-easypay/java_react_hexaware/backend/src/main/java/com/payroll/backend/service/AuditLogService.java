package com.payroll.backend.service;

import com.payroll.backend.dto.AuditLogDTO;
import com.payroll.backend.dto.request.AuditLogRequestDTO;

import java.util.List;

public interface AuditLogService {
    List<AuditLogDTO> getAllAuditLogs();
    AuditLogDTO getAuditLogById(Long logId);
    AuditLogDTO createAuditLog(AuditLogRequestDTO requestDTO);
    void deleteAuditLog(Long logId); // typically no update for audit logs
}

