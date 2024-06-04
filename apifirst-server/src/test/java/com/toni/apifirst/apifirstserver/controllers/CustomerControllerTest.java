package com.toni.apifirst.apifirstserver.controllers;

import com.toni.apifirst.apifirstserver.domain.Customer;
import com.toni.apifirst.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.UUID;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
public class CustomerControllerTest extends BaseTest {

    @DisplayName("Test Delete Conflict With Orders")
    @Test
    void testDeleteConflictWithOrders() throws Exception {
        Customer customer = customerRepository.findAll().iterator().next();

        mockMvc.perform(delete(CustomerController.BASE_URL + "/{customerId}", customer.getId()))
                .andExpect(status().isConflict())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    void testDeleteNotFound() throws Exception {
        mockMvc.perform(delete(CustomerController.BASE_URL + "/{customerId}", UUID.randomUUID()))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    void testDeleteCustomer() throws Exception {
        CustomerDto customer = buildTestCustomerDto();
        Customer savedCustomer = customerRepository.save(customerMapper.dtoToCustomer(customer));

        mockMvc.perform(delete(CustomerController.BASE_URL + "/{customerId}", savedCustomer.getId()))
                .andExpect(status().isNoContent())
                .andExpect(openApi().isValid(OA3_SPEC));

        assert customerRepository.findById(savedCustomer.getId()).isEmpty();
    }

    @Transactional
    @DisplayName("Test Patch Customer")
    @Test
    void testPatchCustomer() throws Exception {
        Customer customer = customerRepository.findAll().iterator().next();

        CustomerPatchDto customerPatch = CustomerPatchDto.builder()
                .name(NameDto.builder()
                        .firstName("Updated")
                        .lastName("Updated2")
                        .build())
                .paymentMethods(Collections.singletonList(CustomerPaymentMethodPatchDto.builder()
                        .id(customer.getPaymentMethods().get(0).getId())
                        .displayName("NEW NAME")
                        .build()))
                .build();

        mockMvc.perform(patch(CustomerController.BASE_URL + "/{customerId}", testCustomer.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerPatch)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name.firstName", equalTo("Updated")))
                .andExpect(jsonPath("$.name.lastName", equalTo("Updated2")))
                .andExpect(jsonPath("$.paymentMethods[0].displayName", equalTo("NEW NAME")))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Transactional
    @DisplayName("Test Patch Customer Not Found")
    @Test
    void testPatchCustomerNotFound() throws Exception {
        Customer customer = customerRepository.findAll().iterator().next();

        CustomerPatchDto customerPatch = CustomerPatchDto.builder()
                .name(NameDto.builder()
                        .firstName("Updated")
                        .lastName("Updated2")
                        .build())
                .paymentMethods(Collections.singletonList(CustomerPaymentMethodPatchDto.builder()
                        .id(customer.getPaymentMethods().get(0).getId())
                        .displayName("NEW NAME")
                        .build()))
                .build();

        mockMvc.perform(patch(CustomerController.BASE_URL + "/{customerId}", UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerPatch)))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }
    
    //test update customer
    @Transactional
    @DisplayName("Test Update Customer")
    @Test
    void testUpdateCustomer() throws Exception {
        Customer customer = customerRepository.findAll().iterator().next();

        customer.getName().setFirstName("Updated");
        customer.getName().setLastName("Updated2");
        customer.getPaymentMethods().get(0).setDisplayName("NEW NAME");

        mockMvc.perform(put(CustomerController.BASE_URL + "/{customerId}", testCustomer.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerMapper.customerToDto(customer))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name.firstName", equalTo("Updated")))
                .andExpect(jsonPath("$.name.lastName", equalTo("Updated2")))
                .andExpect(jsonPath("$.paymentMethods[0].displayName", equalTo("NEW NAME")))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Transactional
    @DisplayName("Test Update Customer Not Found")
    @Test
    void testUpdateCustomerNotFound() throws Exception {
        Customer customer = customerRepository.findAll().iterator().next();

        customer.getName().setFirstName("Updated");
        customer.getName().setLastName("Updated2");
        customer.getPaymentMethods().get(0).setDisplayName("NEW NAME");

        mockMvc.perform(put(CustomerController.BASE_URL + "/{customerId}", UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerMapper.customerToDto(customer))))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Test Create Customer Bad Request")
    @Test
    void testCreateCustomerBadRequest() throws Exception {
        CustomerDto customer = buildTestCustomerDto();
        customer.setName(null);
        customer.setBillToAddress(null);

        mockMvc.perform(post(CustomerController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isBadRequest());
    }

    @DisplayName("Test Create Customer")
    @Test
    void testCreateCustomer() throws Exception {
        CustomerDto customer = buildTestCustomerDto();

        mockMvc.perform(post(CustomerController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    private CustomerDto buildTestCustomerDto() {
        return CustomerDto.builder()
                .name(NameDto.builder()
                        .lastName("Doe")
                        .firstName("John")
                        .build())
                .phone("555-555-5555")
                .email("john@example.com")
                .shipToAddress(AddressDto.builder()
                        .addressLine1("123 Main St")
                        .city("Denver")
                        .state("CO")
                        .zip("80216")
                        .build())
                .billToAddress(AddressDto.builder()
                        .addressLine1("123 Main St")
                        .city("Denver")
                        .state("CO")
                        .zip("80216")
                        .build())
                .build();
    }

    @DisplayName("Get by Id Not Found")
    @Test
    void testGetCustomerByIdNotFound() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL + "/{customerId}", UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Get by Id")
    @Test
    void testGetCustomerById() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL + "/{customerId}", testCustomer.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(testCustomer.getId().toString()))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Test List Customers")
    @Test
    void testListCustomers() throws Exception {
        mockMvc.perform(get(CustomerController.BASE_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)))
                .andExpect(openApi().isValid(OA3_SPEC));
    }
}
