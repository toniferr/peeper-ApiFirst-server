package com.toni.apifirst.apifirstserver.mappers;

import com.toni.apifirst.apifirstserver.domain.PaymentMethod;
import com.toni.apifirst.model.CustomerPaymentMethodPatchDto;
import com.toni.apifirst.model.PaymentMethodDto;
import org.mapstruct.*;


@Mapper
public interface PaymentMethodMapper {

    PaymentMethodDto paymentMethodToDto(PaymentMethod paymentMethod);

    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void updatePaymentMethod(CustomerPaymentMethodPatchDto customerPaymentMethodPatchDto,
                             @MappingTarget PaymentMethod paymentMethod);
}
