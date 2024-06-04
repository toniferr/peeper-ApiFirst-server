package com.toni.apifirst.apifirstserver.services;

import com.toni.apifirst.apifirstserver.domain.Order;
import com.toni.apifirst.apifirstserver.mappers.OrderMapper;
import com.toni.apifirst.apifirstserver.repositories.OrderRepository;
import com.toni.apifirst.model.OrderCreateDto;
import com.toni.apifirst.model.OrderDto;
import com.toni.apifirst.model.OrderPatchDto;
import com.toni.apifirst.model.OrderUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public void deleteOrder(UUID orderId) {
        orderRepository.findById(orderId).ifPresentOrElse(orderRepository::delete, () -> {
            throw new NotFoundException("Order Not Found");
        });
    }

    @Override
    public OrderDto patchOrder(UUID orderId, OrderPatchDto orderPatchDto) {
        Order existingOrder = orderRepository.findById(orderId).orElseThrow(NotFoundException::new);
        orderMapper.patchOrder(orderPatchDto, existingOrder);
        return orderMapper.orderToDto(orderRepository.saveAndFlush(existingOrder));
    }

    @Transactional
    @Override
    public OrderDto updateOrder(UUID orderId, OrderUpdateDto orderUpdateDto) {
        Order existingOrder = orderRepository.findById(orderId).orElseThrow(NotFoundException::new);

        orderMapper.updateOrder(orderUpdateDto, existingOrder);

        Order savedOrder = orderRepository.saveAndFlush(existingOrder);

        return orderMapper.orderToDto(savedOrder);
    }

    @Override
    public OrderDto saveNewOrder(OrderCreateDto orderCreate) {
        Order savedOrder = orderRepository.saveAndFlush(orderMapper.dtoToOrder(orderCreate));

        return orderMapper.orderToDto(savedOrder);
    }

    @Override
    public List<OrderDto> listOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .map(orderMapper::orderToDto)
                .toList();
    }

    @Override
    public OrderDto getOrderById(UUID orderId) {
      return orderMapper.orderToDto(orderRepository.findById(orderId).orElseThrow(NotFoundException::new));
    }
}










