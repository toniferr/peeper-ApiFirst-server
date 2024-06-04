package com.toni.apifirst.apifirstserver.controllers;

import com.toni.apifirst.apifirstserver.services.CustomerService;
import com.toni.apifirst.model.CustomerDto;
import com.toni.apifirst.model.CustomerPatchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static com.toni.apifirst.apifirstserver.controllers.CustomerController.BASE_URL;


@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class CustomerController {

    public static final String BASE_URL = "/v1/customers";

    private final CustomerService customerService;

    @DeleteMapping("/{customerId}")
    ResponseEntity<Void> deleteCustomer(@PathVariable("customerId") UUID customerId){
        customerService.deleteCustomer(customerId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{customerId}")
    ResponseEntity<CustomerDto> patchCustomer(@PathVariable("customerId") UUID customerId,
                                              @RequestBody CustomerPatchDto customer){
        CustomerDto savedCustomer = customerService.patchCustomer(customerId, customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/{customerId}")
    ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") UUID customerId,
                                               @RequestBody CustomerDto customer){
        CustomerDto savedCustomer = customerService.updateCustomer(customerId, customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PostMapping
    ResponseEntity<Void> saveNewCustomer(@RequestBody CustomerDto customer){
        CustomerDto savedCustomer = customerService.saveNewCustomer(customer);
        return ResponseEntity.created(URI.create(BASE_URL + "/" + savedCustomer.getId())).build();
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listCustomers(){
        return ResponseEntity.ok(customerService.listCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customerId") UUID customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }
}



















