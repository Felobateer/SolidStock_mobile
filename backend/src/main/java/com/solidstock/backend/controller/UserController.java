package com.solidstock.backend.controller;

import com.solidstock.backend.model.dto.NotificationDto;
import com.solidstock.backend.model.dto.UserDto;
import com.solidstock.backend.service.NotificationService;
import com.solidstock.backend.service.UserService;
import com.solidstock.backend.exception.ResourceNotFoundException;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;
    private NotificationService notificationService;

    public UserController(UserService userService) {
        this.userService = userService;
        this.notificationService = notificationService;
    }

    // sign up
    @PostMapping
    public ResponseEntity<UserDto> signUp(@RequestBody UserDto userDto) {
        try {
            // Create the user
            UserDto createdUser = userService.createUser(userDto);

            // Prepare the notification
            String recipient = userDto.getEmail(); // Use user's email as the recipient
            String message = "Hi " + userDto.getFirstName() + " " + userDto.getLastName() +
                    ", \nWe are happy to welcome you to Solid Stock.";
            NotificationDto notificationDto = new NotificationDto(
                    message,
                    recipient,
                    userDto.getId());

            // Send the notification
            notificationService.addNewNotification(notificationDto);

            // Return the created user with HTTP 201 status
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the error (for debugging purposes)
            logger.error("Error during user sign-up", e);

            // Return an appropriate HTTP 500 response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    // Get user details
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    // update user details
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserData(@PathVariable Long id, @RequestBody @Valid UserDto userDto) {
        try {
            // Update user data
            UserDto updatedUser = userService.updateUserData(id, userDto);

            // Prepare the notification
            String recipient = updatedUser.getEmail(); // Assuming the updated email is used
            String message = "Hi " + updatedUser.getFirstName() + " " + updatedUser.getLastName() +
                    ", \nYour profile has been successfully updated.";
            NotificationDto notificationDto = new NotificationDto(
                    message,
                    recipient,
                    updatedUser.getId()
            );

            // Send the notification
            notificationService.addNewNotification(notificationDto);

            // Return the updated user with HTTP 200 status
            return ResponseEntity.ok(updatedUser);
        } catch (ResourceNotFoundException e) {
            // Handle user not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        } catch (Exception e) {
            // Log and handle any other errors
            logger.error("Error updating user data", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    // delete user details
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUserData(id);
    }

    // get all users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
