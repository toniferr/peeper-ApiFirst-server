package com.toni.apifirst.apifirstserver.controllers;


import com.toni.apifirst.apifirstserver.domain.Product;
import com.toni.apifirst.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.UUID;

import static com.atlassian.oai.validator.mockmvc.OpenApiValidationMatchers.openApi;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
class ProductControllerTest extends BaseTest {

    @Test
    void testDeleteConflictProductHasOrders() throws Exception {
        mockMvc.perform(delete(ProductController.BASE_URL + "/{productId}", testProduct.getId()))
                .andExpect(status().isConflict())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    void testDeleteProductNotFound() throws Exception {
        mockMvc.perform(delete(ProductController.BASE_URL + "/{productId}", UUID.randomUUID()))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    void testDeleteProduct() throws Exception {
        ProductCreateDto newProduct = createTestProductCreateDto();
        Product savedProduct = productRepository.save(productMapper.dtoToProduct(newProduct));

        mockMvc.perform(delete(ProductController.BASE_URL + "/{productId}", savedProduct.getId()))
                .andExpect(status().isNoContent())
                .andExpect(openApi().isValid(OA3_SPEC));

        assert productRepository.findById(savedProduct.getId()).isEmpty();
    }

    @Transactional
    @Test
    void testPatchProduct() throws Exception {

        Product product = productRepository.findAll().iterator().next();

        ProductPatchDto productPatchDto = productMapper.productToPatchDto(product);

        productPatchDto.setDescription("Updated Description");

        mockMvc.perform(patch(ProductController.BASE_URL + "/{productId}", product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productPatchDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", equalTo("Updated Description")))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Test Patch Product Not Found")
    @Transactional
    @Test
    void testPatchProductNotFound() throws Exception {

        Product product = productRepository.findAll().iterator().next();

        ProductPatchDto productPatchDto = productMapper.productToPatchDto(product);

        productPatchDto.setDescription("Updated Description");

        mockMvc.perform(patch(ProductController.BASE_URL + "/{productId}", UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productPatchDto)))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Transactional
    @Test
    void testUpdateProduct() throws Exception {

        Product product = productRepository.findAll().iterator().next();

        ProductUpdateDto productUpdateDto = productMapper.productToUpdateDto(product);

        productUpdateDto.setDescription("Updated Description");

        mockMvc.perform(put(ProductController.BASE_URL + "/{productId}", product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productUpdateDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description", equalTo("Updated Description")))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Test Update Product Not Found")
    @Transactional
    @Test
    void testUpdateProductNotFound() throws Exception {

        Product product = productRepository.findAll().iterator().next();

        ProductUpdateDto productUpdateDto = productMapper.productToUpdateDto(product);

        productUpdateDto.setDescription("Updated Description");

        mockMvc.perform(put(ProductController.BASE_URL + "/{productId}", UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productUpdateDto)))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    void testCreateProduct() throws Exception {
        ProductCreateDto newProduct = createTestProductCreateDto();

        mockMvc.perform(post(ProductController.BASE_URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(openApi().isValid(OA3_SPEC));

    }

    private ProductCreateDto createTestProductCreateDto() {
        return ProductCreateDto.builder()
                .description("New Product")
                .cost("5.00")
                .price("8.95")
                .categories(Arrays.asList("ELECTRONICS"))
                .images(Arrays.asList(ImageDto.builder()
                        .url("http://example.com/image.jpg")
                        .altText("Image Alt Text")
                        .build()))
                .dimensions(DimensionsDto.builder()
                        .length(10)
                        .width(10)
                        .height(10)
                        .build())
                .build();
    }

    @Test
    void listProducts() throws Exception {
        mockMvc.perform(get(ProductController.BASE_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", greaterThan(0)))
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @DisplayName("Test getProductById Not Found")
    @Test
    void getProductByIdNotFound() throws Exception {
        mockMvc.perform(get(ProductController.BASE_URL + "/{productId}", UUID.randomUUID())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(openApi().isValid(OA3_SPEC));
    }

    @Test
    void getProductById() throws Exception {
        mockMvc.perform(get(ProductController.BASE_URL + "/{productId}", testProduct.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(testProduct.getId().toString())))
                .andExpect(openApi().isValid(OA3_SPEC));
    }
}