package com.solidstock.backend.model.dto;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private Long postalCode;
    private String city;
    private String country;
    private String nationality;
    private LocalDate joinedAt;
    private Boolean premium;

}
