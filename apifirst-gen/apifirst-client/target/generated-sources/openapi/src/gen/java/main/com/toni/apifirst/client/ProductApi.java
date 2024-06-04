package com.toni.apifirst.client;

import com.toni.apifirst.ApiClient;

import com.toni.apifirst.model.ProblemDto;
import com.toni.apifirst.model.ProductCreateDto;
import com.toni.apifirst.model.ProductDto;
import com.toni.apifirst.model.ProductPatchDto;
import com.toni.apifirst.model.ProductUpdateDto;
import java.util.UUID;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-06-04T10:41:17.687869989+02:00[Europe/Madrid]")
public class ProductApi {
    private ApiClient apiClient;

    public ProductApi() {
        this(new ApiClient());
    }

    public ProductApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a new product
     * Create a new product.
     * <p><b>201</b> - Created
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * @param productCreateDto  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void createProduct(ProductCreateDto productCreateDto) throws RestClientException {
        createProductWithHttpInfo(productCreateDto);
    }

    /**
     * Create a new product
     * Create a new product.
     * <p><b>201</b> - Created
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * @param productCreateDto  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> createProductWithHttpInfo(ProductCreateDto productCreateDto) throws RestClientException {
        Object localVarPostBody = productCreateDto;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basic_auth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/products", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a product by ID
     * Delete Product by ID 
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * <p><b>409</b> - Unable to complete request due to a conflict with the current state of the target resource. May be due to constraint violation.
     * @param productId The ID of the product to retrieve (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteProductById(UUID productId) throws RestClientException {
        deleteProductByIdWithHttpInfo(productId);
    }

    /**
     * Delete a product by ID
     * Delete Product by ID 
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * <p><b>409</b> - Unable to complete request due to a conflict with the current state of the target resource. May be due to constraint violation.
     * @param productId The ID of the product to retrieve (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteProductByIdWithHttpInfo(UUID productId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'productId' is set
        if (productId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'productId' when calling deleteProductById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("productId", productId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basic_auth" };

        ParameterizedTypeReference<Void> localReturnType = new ParameterizedTypeReference<Void>() {};
        return apiClient.invokeAPI("/v1/products/{productId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a product by ID
     * Get a product by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param productId The ID of the product to retrieve (required)
     * @return ProductDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProductDto getProductById(UUID productId) throws RestClientException {
        return getProductByIdWithHttpInfo(productId).getBody();
    }

    /**
     * Get a product by ID
     * Get a product by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param productId The ID of the product to retrieve (required)
     * @return ResponseEntity&lt;ProductDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProductDto> getProductByIdWithHttpInfo(UUID productId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'productId' is set
        if (productId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'productId' when calling getProductById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("productId", productId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basic_auth" };

        ParameterizedTypeReference<ProductDto> localReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return apiClient.invokeAPI("/v1/products/{productId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a list of products
     * Get a list of product.
     * <p><b>200</b> - Success
     * <p><b>404</b> - The requested resource was not found.
     * @return List&lt;ProductDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<ProductDto> listProducts() throws RestClientException {
        return listProductsWithHttpInfo().getBody();
    }

    /**
     * Get a list of products
     * Get a list of product.
     * <p><b>200</b> - Success
     * <p><b>404</b> - The requested resource was not found.
     * @return ResponseEntity&lt;List&lt;ProductDto&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<ProductDto>> listProductsWithHttpInfo() throws RestClientException {
        Object localVarPostBody = null;
        

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = {  };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basic_auth" };

        ParameterizedTypeReference<List<ProductDto>> localReturnType = new ParameterizedTypeReference<List<ProductDto>>() {};
        return apiClient.invokeAPI("/v1/products", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Patch a product by ID
     * Patch a product by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param productId The ID of the product to update (required)
     * @param productPatchDto  (required)
     * @return ProductDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProductDto patchProductById(UUID productId, ProductPatchDto productPatchDto) throws RestClientException {
        return patchProductByIdWithHttpInfo(productId, productPatchDto).getBody();
    }

    /**
     * Patch a product by ID
     * Patch a product by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param productId The ID of the product to update (required)
     * @param productPatchDto  (required)
     * @return ResponseEntity&lt;ProductDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProductDto> patchProductByIdWithHttpInfo(UUID productId, ProductPatchDto productPatchDto) throws RestClientException {
        Object localVarPostBody = productPatchDto;
        
        // verify the required parameter 'productId' is set
        if (productId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'productId' when calling patchProductById");
        }
        
        // verify the required parameter 'productPatchDto' is set
        if (productPatchDto == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'productPatchDto' when calling patchProductById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("productId", productId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basic_auth" };

        ParameterizedTypeReference<ProductDto> localReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return apiClient.invokeAPI("/v1/products/{productId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a product by ID
     * Update a product by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param productId The ID of the product to retrieve (required)
     * @param productUpdateDto  (required)
     * @return ProductDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ProductDto updateProductById(UUID productId, ProductUpdateDto productUpdateDto) throws RestClientException {
        return updateProductByIdWithHttpInfo(productId, productUpdateDto).getBody();
    }

    /**
     * Update a product by ID
     * Update a product by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param productId The ID of the product to retrieve (required)
     * @param productUpdateDto  (required)
     * @return ResponseEntity&lt;ProductDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<ProductDto> updateProductByIdWithHttpInfo(UUID productId, ProductUpdateDto productUpdateDto) throws RestClientException {
        Object localVarPostBody = productUpdateDto;
        
        // verify the required parameter 'productId' is set
        if (productId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'productId' when calling updateProductById");
        }
        
        // verify the required parameter 'productUpdateDto' is set
        if (productUpdateDto == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'productUpdateDto' when calling updateProductById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("productId", productId);

        final MultiValueMap<String, String> localVarQueryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders localVarHeaderParams = new HttpHeaders();
        final MultiValueMap<String, String> localVarCookieParams = new LinkedMultiValueMap<String, String>();
        final MultiValueMap<String, Object> localVarFormParams = new LinkedMultiValueMap<String, Object>();

        final String[] localVarAccepts = { 
            "application/json", "application/problem+json"
         };
        final List<MediaType> localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        final String[] localVarContentTypes = { 
            "application/json"
         };
        final MediaType localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

        String[] localVarAuthNames = new String[] { "basic_auth" };

        ParameterizedTypeReference<ProductDto> localReturnType = new ParameterizedTypeReference<ProductDto>() {};
        return apiClient.invokeAPI("/v1/products/{productId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
