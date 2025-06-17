package com.hexaware.easypay.entity;

import com.hexaware.easypay.entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer> {
    List<AuditLog> findByUserUserId(Integer userId);
}

