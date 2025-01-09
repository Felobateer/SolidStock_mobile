package com.solidstock.backend.service.impl;

import com.solidstock.backend.exception.ResourceNotFoundException;
import com.solidstock.backend.mapper.NotificationMapper;
import com.solidstock.backend.model.dto.NotificationDto;
import com.solidstock.backend.model.entity.Notification;
import com.solidstock.backend.model.entity.User;
import com.solidstock.backend.repository.NotificationRepository;
import com.solidstock.backend.repository.UserRepository;
import com.solidstock.backend.service.NotificationService;
import com.solidstock.backend.utils.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class NotificationServiceImpl implements NotificationService {
    @Autowired
    private NotificationRepository notificationRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailSender emailSender;

    @Override
    public NotificationDto addNewNotification(NotificationDto notificationDto) {
        User user = userRepository.findById(notificationDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + notificationDto.getUserId() + " not found"));
        LocalDate currentTime = LocalDate.now();

        Notification notification = new Notification();
        notification.setMessage(notificationDto.getMessage());
        notification.setRecipient(notificationDto.getRecipient());
        notification.setRead(false);
        notification.setUser(user);
        notification.setCreatedAt(currentTime);

        emailSender.sendEmail(user.getEmail(), notificationDto.getRecipient(),
                notificationDto.getMessage());

        notificationRepository.save(notification);
        return NotificationMapper.toDto(notification);
    }

    @Override
    public void deleteNotification(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("notification with id " + id + " not found"));
        notificationRepository.delete(notification);
    }

    @Override
    public void readNotification(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("notification with id " + id + " not found"));
        notification.setRead(true);
    }

    @Override
    public List<Notification> seeUserNotification(Long userId) {
        // Fetch notifications by userId
        List<Notification> notifications = notificationRepository.findByUserId(userId);
        if (notifications.isEmpty()) {
            throw new ResourceNotFoundException("No notifications found for user with ID: " + userId);
        }
        return notifications;
    }

    @Override
    public Notification seeOneNotification(Long id, Long userId) {
        // Fetch notifications by userId
        List<Notification> notifications = notificationRepository.findByUserId(userId);

        // Filter to find the specific notification by ID
        return notifications.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with ID: " + id + " for user ID: " + userId));
    }
}
