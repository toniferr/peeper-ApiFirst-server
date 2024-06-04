package com.toni.apifirst.apifirstserver.mappers;

import com.toni.apifirst.model.ProductImagePatchDto;
import com.toni.apifirst.model.ProductImageUpdateDto;
import com.toni.apifirst.apifirstserver.domain.Image;
import org.mapstruct.*;


@Mapper
public interface ImageMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    void patchImage(ProductImagePatchDto image, @MappingTarget Image target);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "product", ignore = true)
    @Mapping(target = "dateUpdated", ignore = true)
    @Mapping(target = "dateCreated", ignore = true)
    void updateImage(ProductImageUpdateDto image, @MappingTarget Image target);
}
