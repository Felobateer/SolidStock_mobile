package com.solidstock.backend.controller;

import com.solidstock.backend.exception.InsufficientFundsException;
import com.solidstock.backend.exception.ResourceNotFoundException;
import com.solidstock.backend.model.dto.NotificationDto;
import com.solidstock.backend.model.dto.TransferRequestDto;
import com.solidstock.backend.model.dto.TransferResponseDto;
import com.solidstock.backend.service.NotificationService;
import com.solidstock.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private NotificationService notificationService;

    /**
     * Transfer funds between two accounts.
     *
     * @param transferRequestDto contains details for the transfer (source, destination, amount).
     * @return TransferResponseDto with the result of the transfer.
     */
    @PostMapping("/transfer/{userId}")
    public ResponseEntity<TransferResponseDto> transferFunds(@RequestBody TransferRequestDto transferRequestDto, @PathVariable Long userId) {
        try {
            // Process the fund transfer
            TransferResponseDto response = paymentService.transferFunds(transferRequestDto);

            // Prepare the notification message
            String message = String.format(
                    "You have successfully transferred %.2f to account %s.",
                    transferRequestDto.getAmount(),
                    transferRequestDto.getDestinationAccountNumber()
            );
            String recipient = transferRequestDto.getSourceAccountNumber(); // Assuming the source account owner is notified

            // Create the notification DTO
            NotificationDto notificationDto = new NotificationDto(
                    message,
                    recipient,
                    userId
            );

            // Send the notification
            notificationService.addNewNotification(notificationDto);

            // Return the transfer response
            return ResponseEntity.ok(response);
        } catch (InsufficientFundsException | ResourceNotFoundException e) {
            // Handle known exceptions with a proper response
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        } catch (Exception e) {
            // Log unexpected errors and return a generic response
            logger.error("Error processing transfer", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }
}
