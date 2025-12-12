package com.harshilinfotech.customerservice.service;

import com.harshilinfotech.customerservice.dto.CustomerRequest;
import com.harshilinfotech.customerservice.dto.CustomerResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerService {

    String createCustomer(@Valid CustomerRequest request);

    void updateCustomer(@Valid CustomerRequest request);

    List<CustomerResponse> findAllCustomers();

    Boolean existsById(String customerId);

    CustomerResponse findById(String customerId);

    void deleteCustomerById(String customerId);

}