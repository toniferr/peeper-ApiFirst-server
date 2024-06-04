package com.toni.apifirst.apifirstserver.controllers;

import com.toni.apifirst.apifirstserver.services.ProductService;
import com.toni.apifirst.model.ProductCreateDto;
import com.toni.apifirst.model.ProductDto;
import com.toni.apifirst.model.ProductPatchDto;
import com.toni.apifirst.model.ProductUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import static com.toni.apifirst.apifirstserver.controllers.ProductController.BASE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(BASE_URL)
public class ProductController {
    public static final String BASE_URL = "/v1/products";

    private final ProductService productService;

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") UUID productId){
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> patchProduct(@PathVariable("productId") UUID productId,
                                                    @RequestBody ProductPatchDto product){
        ProductDto savedProduct = productService.patchProduct(productId, product);
        return ResponseEntity.ok(savedProduct);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") UUID productId,
                                                    @RequestBody ProductUpdateDto product){
        ProductDto savedProduct = productService.updateProduct(productId, product);
        return ResponseEntity.ok(savedProduct);
    }

    @PostMapping
    public ResponseEntity<Void> saveNewProduct(@RequestBody ProductCreateDto product){
        ProductDto savedProduct = productService.saveNewProduct(product);

        UriComponents uriComponents = UriComponentsBuilder.fromPath(BASE_URL + "/{product_id}")
                .buildAndExpand(savedProduct.getId());

        return ResponseEntity.created(URI.create(uriComponents.getPath())).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> listProducts(){
        return ResponseEntity.ok(productService.listProducts());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("productId") UUID productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }
}
