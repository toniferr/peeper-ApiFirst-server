package com.toni.apifirst.apifirstserver.services;

import com.toni.apifirst.apifirstserver.domain.Product;
import com.toni.apifirst.apifirstserver.mappers.ProductMapper;
import com.toni.apifirst.apifirstserver.repositories.OrderRepository;
import com.toni.apifirst.apifirstserver.repositories.ProductRepository;
import com.toni.apifirst.model.ProductCreateDto;
import com.toni.apifirst.model.ProductDto;
import com.toni.apifirst.model.ProductPatchDto;
import com.toni.apifirst.model.ProductUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final OrderRepository orderRepository;

    @Override
    public void deleteProduct(UUID productId) {
        productRepository.findById(productId).ifPresentOrElse(product -> {
            if (!orderRepository.findAllByOrderLines_Product(product).isEmpty()){
                throw new ConflictException("Product is used in orders");
            }

            productRepository.delete(product);
        }, () -> {
            throw new NotFoundException("Product Not Found");
        });
    }

    @Override
    public ProductDto patchProduct(UUID productId, ProductPatchDto product) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(NotFoundException::new);
        productMapper.patchProduct(product, existingProduct);
        return productMapper.productToDto(productRepository.save(existingProduct));
    }

    @Override
    public ProductDto updateProduct(UUID productId, ProductUpdateDto product) {
        Product existingProduct = productRepository.findById(productId).orElseThrow(NotFoundException::new);
        productMapper.updateProduct(product, existingProduct);
        return productMapper.productToDto(productRepository.save(existingProduct));
    }

    @Override
    public ProductDto saveNewProduct(ProductCreateDto product) {
       return productMapper.productToDto(productRepository.save(productMapper.dtoToProduct(product)));
    }

    @Override
    public List<ProductDto> listProducts() {
        return StreamSupport.stream(productRepository.findAll().spliterator(), false)
                .map(productMapper::productToDto)
                .toList();
    }

    @Override
    public ProductDto getProductById(UUID productId) {
        return productMapper.productToDto(productRepository.findById(productId).orElseThrow(NotFoundException::new));
    }
}










