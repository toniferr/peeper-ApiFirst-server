package com.toni.apifirst.apifirstserver.controllers;

import com.toni.apifirst.apifirstserver.services.OrderService;
import com.toni.apifirst.model.OrderCreateDto;
import com.toni.apifirst.model.OrderDto;
import com.toni.apifirst.model.OrderPatchDto;
import com.toni.apifirst.model.OrderUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static com.toni.apifirst.apifirstserver.controllers.OrderController.BASE_URL;


@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class OrderController {

    public static final String BASE_URL = "/v1/orders";

    private final OrderService orderService;

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") UUID orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{orderId}")
    public ResponseEntity<OrderDto> patchOrder(@PathVariable("orderId") UUID orderId,
                                               @RequestBody OrderPatchDto orderPatchDto){
        OrderDto savedOrder = orderService.patchOrder(orderId, orderPatchDto);
        return ResponseEntity.ok(savedOrder);
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable("orderId") UUID orderId,
                                               @RequestBody OrderUpdateDto orderUpdateDto){
        OrderDto savedOrder = orderService.updateOrder(orderId, orderUpdateDto);
        return ResponseEntity.ok(savedOrder);
    }

    @PostMapping
    public ResponseEntity<Void> saveNewOrder(@RequestBody OrderCreateDto orderCreate){
        OrderDto savedOrder = orderService.saveNewOrder(orderCreate);

        UriComponents uriComponents = UriComponentsBuilder.fromPath(BASE_URL + "/{orderId}")
               .buildAndExpand(savedOrder.getId());

        return ResponseEntity.created(URI.create(uriComponents.getPath())).build();
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> listOrders(){
        return ResponseEntity.ok(orderService.listOrders());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getProductById(@PathVariable("orderId") UUID orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }
}
