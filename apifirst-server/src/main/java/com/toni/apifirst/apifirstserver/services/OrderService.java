package com.toni.apifirst.apifirstserver.services;


import com.toni.apifirst.model.OrderCreateDto;
import com.toni.apifirst.model.OrderDto;
import com.toni.apifirst.model.OrderPatchDto;
import com.toni.apifirst.model.OrderUpdateDto;

import java.util.List;
import java.util.UUID;


public interface OrderService {
    List<OrderDto> listOrders();

    OrderDto getOrderById(UUID orderId);

    OrderDto saveNewOrder(OrderCreateDto orderCreate);

    OrderDto updateOrder(UUID orderId, OrderUpdateDto orderUpdateDto);

    OrderDto patchOrder(UUID orderId, OrderPatchDto orderPatchDto);

    void deleteOrder(UUID orderId);
}
