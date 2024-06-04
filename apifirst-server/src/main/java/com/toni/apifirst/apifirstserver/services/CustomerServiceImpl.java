package com.toni.apifirst.apifirstserver.services;

import com.toni.apifirst.apifirstserver.domain.Customer;
import com.toni.apifirst.apifirstserver.mappers.CustomerMapper;
import com.toni.apifirst.apifirstserver.repositories.CustomerRepository;
import com.toni.apifirst.apifirstserver.repositories.OrderRepository;
import com.toni.apifirst.model.CustomerDto;
import com.toni.apifirst.model.CustomerPatchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public void deleteCustomer(UUID customerId) {
        customerRepository.findById(customerId).ifPresentOrElse(customer -> {
            if (!orderRepository.findAllByCustomer(customer).isEmpty()) {
                throw new ConflictException("Customer has orders");
            }
            customerRepository.delete(customer);
        }, () -> {
            throw new NotFoundException("Customer Not Found");
        });
    }

    @Transactional
    @Override
    public CustomerDto patchCustomer(UUID customerId, CustomerPatchDto customer) {
        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(NotFoundException::new);

        customerMapper.patchCustomer(customer, existingCustomer);

        return customerMapper.customerToDto(customerRepository.saveAndFlush(existingCustomer));
    }

    @Transactional
    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customer) {
        Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(NotFoundException::new);
        customerMapper.updateCustomer(customer, existingCustomer);

        return customerMapper.customerToDto(customerRepository.save(existingCustomer));
    }

    @Transactional
    @Override
    public CustomerDto saveNewCustomer(CustomerDto customer) {
        Customer savedCustomer = customerRepository.save(customerMapper.dtoToCustomer(customer));
        customerRepository.flush();
        return customerMapper.customerToDto(savedCustomer);
    }

    @Override
    public List<CustomerDto> listCustomers() {
        return StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .map(customerMapper::customerToDto)
                .toList();
    }

    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return customerMapper.customerToDto(customerRepository.findById(customerId).orElseThrow(NotFoundException::new));
    }
}
