package com.payroll.backend.service.impl;

import com.payroll.backend.dto.AuditLogDTO;
import com.payroll.backend.dto.request.AuditLogRequestDTO;
import com.payroll.backend.entity.AuditLog;
import com.payroll.backend.entity.Users;
import com.payroll.backend.repository.AuditLogRepository;
import com.payroll.backend.repository.UsersRepository;
import com.payroll.backend.service.AuditLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private UsersRepository usersRepository;

    private AuditLogDTO convertToDTO(AuditLog log) {
        return new AuditLogDTO(
                log.getLogId(),
                log.getUser().getUserId(),
                log.getUser().getUserName(), // assumes `username` exists
                log.getAction(),
                log.getTimestamp(),
                log.getDetails()
        );
    }

    @Override
    public List<AuditLogDTO> getAllAuditLogs() {
        return auditLogRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuditLogDTO getAuditLogById(Long logId) {
        AuditLog log = auditLogRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Audit log not found with id: " + logId));
        return convertToDTO(log);
    }

    @Override
    public AuditLogDTO createAuditLog(AuditLogRequestDTO requestDTO) {
        Users user = usersRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + requestDTO.getUserId()));

        AuditLog log = new AuditLog();
        log.setUser(user);
        log.setAction(requestDTO.getAction());
        log.setTimestamp(requestDTO.getTimestamp());
        log.setDetails(requestDTO.getDetails());

        return convertToDTO(auditLogRepository.save(log));
    }

    @Override
    public void deleteAuditLog(Long logId) {
        AuditLog log = auditLogRepository.findById(logId)
                .orElseThrow(() -> new RuntimeException("Audit log not found with id: " + logId));
        auditLogRepository.delete(log);
    }
}

