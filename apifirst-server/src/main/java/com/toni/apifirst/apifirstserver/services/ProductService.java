package com.toni.apifirst.apifirstserver.services;

import com.toni.apifirst.model.ProductCreateDto;
import com.toni.apifirst.model.ProductDto;
import com.toni.apifirst.model.ProductPatchDto;
import com.toni.apifirst.model.ProductUpdateDto;

import java.util.List;
import java.util.UUID;


public interface ProductService {

    ProductDto updateProduct(UUID productId, ProductUpdateDto product);
    List<ProductDto> listProducts();

    ProductDto getProductById(UUID productId);

    ProductDto saveNewProduct(ProductCreateDto product);

    ProductDto patchProduct(UUID productId, ProductPatchDto product);

    void deleteProduct(UUID productId);
}
