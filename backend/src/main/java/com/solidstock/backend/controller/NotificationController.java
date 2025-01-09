package com.solidstock.backend.controller;

import com.solidstock.backend.model.entity.Notification;
import com.solidstock.backend.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    /**
     * Get all notifications for a specific user
     *
     * @param userId the ID of the user
     * @return a list of notifications
     */
    @GetMapping("/user/{userId}")
    public List<Notification> getUserNotifications(@PathVariable Long userId) {
        return notificationService.seeUserNotification(userId);
    }

    /**
     * Get a specific notification for a user by ID
     *
     * @param userId the ID of the user
     * @param notificationId the ID of the notification
     * @return the requested notification
     */
    @GetMapping("/user/{userId}/{notificationId}")
    public Notification getNotificationById(
            @PathVariable Long userId,
            @PathVariable Long notificationId) {
        return notificationService.seeOneNotification(notificationId, userId);
    }
}
