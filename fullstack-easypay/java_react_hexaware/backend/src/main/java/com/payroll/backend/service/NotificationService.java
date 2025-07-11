package com.payroll.backend.service;

import com.payroll.backend.dto.NotificationDTO;
import com.payroll.backend.dto.request.NotificationRequestDTO;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getAllNotifications();
    NotificationDTO getNotificationById(Long notificationId);
    NotificationDTO createNotification(NotificationRequestDTO requestDTO);
    NotificationDTO updateNotification(Long notificationId, NotificationRequestDTO requestDTO);
    void deleteNotification(Long notificationId);
}


