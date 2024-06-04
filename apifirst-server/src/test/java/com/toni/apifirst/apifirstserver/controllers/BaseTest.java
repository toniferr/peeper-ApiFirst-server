package com.toni.apifirst.apifirstserver.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.toni.apifirst.apifirstserver.domain.Customer;
import com.toni.apifirst.apifirstserver.domain.Order;
import com.toni.apifirst.apifirstserver.domain.Product;
import com.toni.apifirst.apifirstserver.mappers.CustomerMapper;
import com.toni.apifirst.apifirstserver.mappers.OrderMapper;
import com.toni.apifirst.apifirstserver.mappers.ProductMapper;
import com.toni.apifirst.apifirstserver.repositories.CustomerRepository;
import com.toni.apifirst.apifirstserver.repositories.OrderRepository;
import com.toni.apifirst.apifirstserver.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zalando.logbook.Logbook;
import org.zalando.logbook.servlet.LogbookFilter;


public class BaseTest {

    public static final String OA3_SPEC = "https://api.redocly.com/registry/bundle/toniferr/API%20First%20with%20springboot/v1/openapi.yaml?branch=develop";

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    ObjectMapper objectMapper;

    public MockMvc mockMvc;

    Customer testCustomer;
    Product testProduct;
    Order testOrder;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilters(new LogbookFilter(Logbook.create()))
                .build();

        testCustomer = customerRepository.findAll().iterator().next();
        testProduct = productRepository.findAll().iterator().next();
        testOrder = orderRepository.findAll().iterator().next();
    }

}
