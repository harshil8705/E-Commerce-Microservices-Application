package com.harshilinfotech.customerservice.service;

import com.harshilinfotech.customerservice.dto.CustomerRequest;
import com.harshilinfotech.customerservice.dto.CustomerResponse;
import com.harshilinfotech.customerservice.entity.Customer;
import com.harshilinfotech.customerservice.exception.CustomerNotFoundException;
import com.harshilinfotech.customerservice.repository.CustomerRepository;
import com.harshilinfotech.customerservice.util.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public String createCustomer(CustomerRequest request) {

        Customer customer = customerRepository.save(customerMapper.toCustomer(request));
        return customer.getId();

    }

    @Override
    public void updateCustomer(CustomerRequest request) {

        Customer customer = customerRepository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(format("Cannot update customer:: No customer found with the provided ID:: %s", request.id())));

        mergeCustomer(customer, request);

        customerRepository.save(customer);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {

        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerResponse
                )
                .toList();

    }

    @Override
    public Boolean existsById(String customerId) {

        return customerRepository.findById(customerId).isPresent();

    }

    @Override
    public CustomerResponse findById(String customerId) {

        return customerRepository.findById(customerId)
                .map(customerMapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(format("No customer found with the provided ID:: %s", customerId)));

    }

    @Override
    public void deleteCustomerById(String customerId) {

        customerRepository.deleteById(customerId);

    }

    private void mergeCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }

        if (StringUtils.isNotBlank(request.lastname())) {
            customer.setLastname(request.lastname());
        }

        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }

        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }
}