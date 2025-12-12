package com.harshilinfotech.customerservice.exception.dto;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}