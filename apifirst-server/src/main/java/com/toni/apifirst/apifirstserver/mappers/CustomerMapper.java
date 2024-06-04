package com.toni.apifirst.apifirstserver.mappers;

import com.toni.apifirst.apifirstserver.domain.Customer;
import com.toni.apifirst.model.CustomerDto;
import com.toni.apifirst.model.CustomerPatchDto;
import org.mapstruct.*;


@Mapper
@DecoratedWith(CustomerMapperDecorator.class)
public interface CustomerMapper {

    CustomerPatchDto customerToPatchDto(Customer customer);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "shipToAddress.id", ignore = true)
    @Mapping(target = "billToAddress.id", ignore = true)
    @Mapping(target = "paymentMethods", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void patchCustomer(CustomerPatchDto customerPatchDto, @MappingTarget Customer target);
    CustomerDto customerToDto(Customer customer);

    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    Customer dtoToCustomer(CustomerDto customerDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    void updateCustomer(CustomerDto customerDto, @MappingTarget Customer customer);
}
