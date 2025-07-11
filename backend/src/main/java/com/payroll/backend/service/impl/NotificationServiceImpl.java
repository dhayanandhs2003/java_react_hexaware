package com.payroll.backend.service.impl;

import com.payroll.backend.dto.NotificationDTO;
import com.payroll.backend.dto.request.NotificationRequestDTO;
import com.payroll.backend.entity.Notification;
import com.payroll.backend.entity.Users;
import com.payroll.backend.exception.ResourceNotFoundException;
import com.payroll.backend.repository.NotificationRepository;
import com.payroll.backend.repository.UsersRepository;
import com.payroll.backend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private UsersRepository userRepository;

    @Override
    public List<NotificationDTO> getAllNotifications() {
        List<Notification> notifications = notificationRepository.findAll();
        return notifications.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public NotificationDTO getNotificationById(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification", "id", notificationId));
        return mapToDTO(notification);
    }

    @Override
    public NotificationDTO createNotification(NotificationRequestDTO requestDTO) {
        Users user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", requestDTO.getUserId()));

        Notification notification = new Notification();
        notification.setUser(user);
        notification.setMessage(requestDTO.getMessage());
        notification.setType(requestDTO.getType());
        notification.setStatus(requestDTO.getStatus());
        notification.setCreatedOn(requestDTO.getCreatedOn());

        Notification saved = notificationRepository.save(notification);
        return mapToDTO(saved);
    }

    @Override
    public NotificationDTO updateNotification(Long notificationId, NotificationRequestDTO requestDTO) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification", "id", notificationId));

        Users user = userRepository.findById(requestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", requestDTO.getUserId()));

        notification.setUser(user);
        notification.setMessage(requestDTO.getMessage());
        notification.setType(requestDTO.getType());
        notification.setStatus(requestDTO.getStatus());
        notification.setCreatedOn(requestDTO.getCreatedOn());

        Notification updated = notificationRepository.save(notification);
        return mapToDTO(updated);
    }

    @Override
    public void deleteNotification(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification", "id", notificationId));
        notificationRepository.delete(notification);
    }

    // Optional: Mark as read
    public NotificationDTO markAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new ResourceNotFoundException("Notification", "id", notificationId));

        notification.setStatus(com.payroll.backend.enums.NotificationStatus.READ);
        Notification updated = notificationRepository.save(notification);
        return mapToDTO(updated);
    }

    // Helper method to convert entity to DTO
    private NotificationDTO mapToDTO(Notification notification) {
        return new NotificationDTO(
                notification.getNotificationId(),
                notification.getUser().getUserId(),
                notification.getUser().getUserName(), // ensure getUsername() exists in Users entity
                notification.getMessage(),
                notification.getType(),
                notification.getStatus(),
                notification.getCreatedOn()
        );
    }
}
