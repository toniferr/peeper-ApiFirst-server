package com.toni.apifirst.apifirstserver.mappers;

import com.toni.apifirst.apifirstserver.domain.Order;
import com.toni.apifirst.model.OrderCreateDto;
import com.toni.apifirst.model.OrderDto;
import com.toni.apifirst.model.OrderPatchDto;
import com.toni.apifirst.model.OrderUpdateDto;
import org.mapstruct.*;


@Mapper
@DecoratedWith(OrderMapperDecorator.class)
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "shipmentInfo", ignore = true)
    @Mapping(target = "orderStatus", ignore = true)
    @Mapping(target = "selectedPaymentMethod", ignore = true)
    @Mapping(target = "orderLines", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void patchOrder(OrderPatchDto orderPatchDto, @MappingTarget Order target);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "shipmentInfo", ignore = true)
    @Mapping(target = "orderStatus", ignore = true)
    @Mapping(target = "selectedPaymentMethod", ignore = true)
    @Mapping(target = "orderLines", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    void updateOrder(OrderUpdateDto orderDto, @MappingTarget Order order);

    @Mapping(target = "selectPaymentMethodId", ignore = true)
    @Mapping(target = "customerId", ignore = true)
    OrderUpdateDto orderToUpdateDto(Order order);
    @Mapping(target = "shipmentInfo", ignore = true)
    @Mapping(target = "selectedPaymentMethod", ignore = true)
    @Mapping(target = "orderStatus", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "customer", ignore = true)
    Order dtoToOrder(OrderCreateDto orderDto);

    @Mapping(target = "selectedPaymentMethod", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    Order dtoToOrder(OrderDto orderDto);

    OrderDto orderToDto(Order order);
}
