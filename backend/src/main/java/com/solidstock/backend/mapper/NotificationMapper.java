package com.solidstock.backend.mapper;

import com.solidstock.backend.model.dto.NotificationDto;
import com.solidstock.backend.model.entity.Notification;

public class NotificationMapper {
    public static NotificationDto toDto(Notification notification) {
        return new NotificationDto(
                notification.getMessage(),
                notification.getRecipient(),
                notification.getUser().getId()
        );
    }
}
