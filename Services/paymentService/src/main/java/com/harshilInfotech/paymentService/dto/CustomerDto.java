package com.harshilInfotech.paymentService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record CustomerDto(
        String id,

        @NotNull(message = "Firstname is Required")
        String firstname,

        @NotNull(message = "Lastname is Required")
        String lastname,

        @NotNull(message = "Email is required")
        @Email(message = "The customer is not correctly formatted")
        String email
) {
}