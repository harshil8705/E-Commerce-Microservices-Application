package com.harshilinfotech.customerservice.dto;


import com.harshilinfotech.customerservice.entity.Address;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {
}