package com.toni.apifirst.apifirstserver.services;

import com.toni.apifirst.model.CustomerDto;
import com.toni.apifirst.model.CustomerPatchDto;

import java.util.List;
import java.util.UUID;


public interface CustomerService {
    List<CustomerDto> listCustomers();

    CustomerDto getCustomerById(UUID customerId);

    CustomerDto saveNewCustomer(CustomerDto customer);

    CustomerDto updateCustomer(UUID customerId, CustomerDto customer);

    CustomerDto patchCustomer(UUID customerId, CustomerPatchDto customer);

    void deleteCustomer(UUID customerId);
}
