package com.toni.apifirst.apifirstserver.controllers;


import com.toni.apifirst.apifirstserver.domain.Order;
import com.toni.apifirst.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class OrderControllerTest extends BaseTest {

    @Test
    void testDeleteNotFound() throws Exception {
        mockMvc.perform(delete(OrderController.BASE_URL + "/{orderId}", UUID.randomUUID()))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Transactional
    @Test
    void testDeleteOrder() throws Exception {
        OrderCreateDto dto = createNewOrderDto();
        Order savedOrder = orderRepository.save(orderMapper.dtoToOrder(dto));

        mockMvc.perform(delete(OrderController.BASE_URL + "/{orderId}", savedOrder.getId()))
                .andExpect(status().isNoContent())
                .andExpect(openApi().isValid(OA3_SPEC));

        assert orderRepository.findById(savedOrder.getId()).isEmpty();
    }

    @Test
    @Transactional
    void testPatchOrder() throws Exception {

        Order order = orderRepository.findAll().get(0);

        OrderPatchDto orderPatch = OrderPatchDto.builder()
                .orderLines(Collections.singletonList(OrderLinePatchDto.builder()
                        .id(order.getOrderLines().get(0).getId())
                        .orderQuantity(333)
                        .build()))
                .build();

        mockMvc.perform(patch(OrderController.BASE_URL + "/{orderId}", testOrder.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderPatch))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(testOrder.getId().toString())))
                .andExpect(jsonPath("$.orderLines[0].orderQuantity", equalTo(333)))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Test Patch Order Not Found")
    @Test
    @Transactional
    void testPatchOrderNotFound() throws Exception {

        Order order = orderRepository.findAll().get(0);

        OrderPatchDto orderPatch = OrderPatchDto.builder()
                .orderLines(Collections.singletonList(OrderLinePatchDto.builder()
                        .id(order.getOrderLines().get(0).getId())
                        .orderQuantity(333)
                        .build()))
                .build();

        mockMvc.perform(patch(OrderController.BASE_URL + "/{orderId}", UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderPatch))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    @Transactional
    void testUpdateOrder() throws Exception {

        Order order = orderRepository.findAll().get(0);

        order.getOrderLines().get(0).setOrderQuantity(222);

        OrderUpdateDto orderUpdate = orderMapper.orderToUpdateDto(order);

        mockMvc.perform(put(OrderController.BASE_URL + "/{orderId}", testOrder.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderUpdate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(testOrder.getId().toString())))
                .andExpect(jsonPath("$.orderLines[0].orderQuantity", equalTo(222)))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Test Update Order Not Found")
    @Test
    @Transactional
    void testUpdateOrderNotFound() throws Exception {

        Order order = orderRepository.findAll().get(0);

        order.getOrderLines().get(0).setOrderQuantity(222);

        OrderUpdateDto orderUpdate = orderMapper.orderToUpdateDto(order);

        mockMvc.perform(put(OrderController.BASE_URL + "/{orderId}", UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderUpdate))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    @Transactional
    void testCreateOrder() throws Exception {
        OrderCreateDto orderCreate = createNewOrderDto();

        System.out.println(objectMapper.writeValueAsString(orderCreate));

        mockMvc.perform(post(OrderController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderCreate)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    private OrderCreateDto createNewOrderDto() {
        return OrderCreateDto.builder()
                .customerId(testCustomer.getId())
                .selectPaymentMethodId(testCustomer.getPaymentMethods().get(0).getId())
                .orderLines(Arrays.asList(OrderLineCreateDto.builder()
                        .productId(testProduct.getId())
                        .orderQuantity(1)
                        .build()))
                .build();
    }

    @Test
    void listOrders() throws Exception {
        mockMvc.perform(get(OrderController.BASE_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Test getOrderById Not Found")
    @Test
    void getOrderByIdNotFound() throws Exception {
        mockMvc.perform(get(OrderController.BASE_URL + "/{orderId}", UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    void getOrderById() throws Exception {
        mockMvc.perform(get(OrderController.BASE_URL + "/{orderId}", testOrder.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(testOrder.getId().toString())))
                .andExpect(openApi().isValid(OA3_SPEC));
    }
}