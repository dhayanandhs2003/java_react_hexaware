package com.payroll.backend.repository;

import com.payroll.backend.entity.AuditLog;
import com.payroll.backend.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

    // Get all logs for a specific user
//    List<AuditLog> findByUser(Users user);
}

