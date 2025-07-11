package com.payroll.backend.repository;

import com.payroll.backend.entity.Notification;
import com.payroll.backend.entity.Users;
import com.payroll.backend.enums.NotificationStatus;
import com.payroll.backend.enums.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

//    // Get all notifications for a user
//    List<Notification> findByUser(Users user);
//
//    // Optional: Filter unread notifications
//    List<Notification> findByUserAndStatus(Users user, NotificationStatus status);
//
//    // Optional: Filter by type (info, warning, alert)
//    List<Notification> findByUserAndType(Users user, NotificationType type);
}
