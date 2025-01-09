package com.solidstock.backend.service;

import com.solidstock.backend.model.dto.NotificationDto;
import com.solidstock.backend.model.entity.Notification;

import java.util.List;

public interface NotificationService {
    NotificationDto addNewNotification(NotificationDto notificationDto);
    void deleteNotification(Long id);
    void readNotification(Long id);
    List<Notification> seeUserNotification(Long userId);
    Notification seeOneNotification(Long id, Long userId);
}
