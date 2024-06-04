package com.toni.apifirst.client;

import com.toni.apifirst.ApiClient;

import com.toni.apifirst.model.OrderCreateDto;
import com.toni.apifirst.model.OrderDto;
import com.toni.apifirst.model.OrderPatchDto;
import com.toni.apifirst.model.OrderUpdateDto;
import com.toni.apifirst.model.ProblemDto;
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
public class OrderApi {
    private ApiClient apiClient;

    public OrderApi() {
        this(new ApiClient());
    }

    public OrderApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create Order
     * Create Order
     * <p><b>201</b> - Order Created
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * @param orderCreateDto  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void createOrder(OrderCreateDto orderCreateDto) throws RestClientException {
        createOrderWithHttpInfo(orderCreateDto);
    }

    /**
     * Create Order
     * Create Order
     * <p><b>201</b> - Order Created
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * @param orderCreateDto  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> createOrderWithHttpInfo(OrderCreateDto orderCreateDto) throws RestClientException {
        Object localVarPostBody = orderCreateDto;
        

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
        return apiClient.invokeAPI("/v1/orders", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a order by ID
     * Patch a order by ID 
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param orderId The ID value of the order. This value is a UUID. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteOrderById(UUID orderId) throws RestClientException {
        deleteOrderByIdWithHttpInfo(orderId);
    }

    /**
     * Delete a order by ID
     * Patch a order by ID 
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param orderId The ID value of the order. This value is a UUID. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteOrderByIdWithHttpInfo(UUID orderId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'orderId' when calling deleteOrderById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("orderId", orderId);

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
        return apiClient.invokeAPI("/v1/orders/{orderId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get Order by id
     * Get Order by id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param orderId The ID value of the order. This value is a UUID. (required)
     * @return OrderDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public OrderDto getOrderById(UUID orderId) throws RestClientException {
        return getOrderByIdWithHttpInfo(orderId).getBody();
    }

    /**
     * Get Order by id
     * Get Order by id
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param orderId The ID value of the order. This value is a UUID. (required)
     * @return ResponseEntity&lt;OrderDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OrderDto> getOrderByIdWithHttpInfo(UUID orderId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'orderId' when calling getOrderById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("orderId", orderId);

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

        ParameterizedTypeReference<OrderDto> localReturnType = new ParameterizedTypeReference<OrderDto>() {};
        return apiClient.invokeAPI("/v1/orders/{orderId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * List Orders
     * List Orders
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @return List&lt;OrderDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<OrderDto> listOrders() throws RestClientException {
        return listOrdersWithHttpInfo().getBody();
    }

    /**
     * List Orders
     * List Orders
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @return ResponseEntity&lt;List&lt;OrderDto&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<OrderDto>> listOrdersWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<OrderDto>> localReturnType = new ParameterizedTypeReference<List<OrderDto>>() {};
        return apiClient.invokeAPI("/v1/orders", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Patch Order
     * Patch Order
     * <p><b>200</b> - Order Updated
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param orderId The ID value of the order. This value is a UUID. (required)
     * @param orderPatchDto  (optional)
     * @return OrderDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public OrderDto patchOrder(UUID orderId, OrderPatchDto orderPatchDto) throws RestClientException {
        return patchOrderWithHttpInfo(orderId, orderPatchDto).getBody();
    }

    /**
     * Patch Order
     * Patch Order
     * <p><b>200</b> - Order Updated
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param orderId The ID value of the order. This value is a UUID. (required)
     * @param orderPatchDto  (optional)
     * @return ResponseEntity&lt;OrderDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OrderDto> patchOrderWithHttpInfo(UUID orderId, OrderPatchDto orderPatchDto) throws RestClientException {
        Object localVarPostBody = orderPatchDto;
        
        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'orderId' when calling patchOrder");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("orderId", orderId);

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

        ParameterizedTypeReference<OrderDto> localReturnType = new ParameterizedTypeReference<OrderDto>() {};
        return apiClient.invokeAPI("/v1/orders/{orderId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update Order
     * Update Order
     * <p><b>200</b> - Order Updated
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param orderId The ID value of the order. This value is a UUID. (required)
     * @param orderUpdateDto  (optional)
     * @return OrderDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public OrderDto updateOrder(UUID orderId, OrderUpdateDto orderUpdateDto) throws RestClientException {
        return updateOrderWithHttpInfo(orderId, orderUpdateDto).getBody();
    }

    /**
     * Update Order
     * Update Order
     * <p><b>200</b> - Order Updated
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param orderId The ID value of the order. This value is a UUID. (required)
     * @param orderUpdateDto  (optional)
     * @return ResponseEntity&lt;OrderDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<OrderDto> updateOrderWithHttpInfo(UUID orderId, OrderUpdateDto orderUpdateDto) throws RestClientException {
        Object localVarPostBody = orderUpdateDto;
        
        // verify the required parameter 'orderId' is set
        if (orderId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'orderId' when calling updateOrder");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("orderId", orderId);

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

        ParameterizedTypeReference<OrderDto> localReturnType = new ParameterizedTypeReference<OrderDto>() {};
        return apiClient.invokeAPI("/v1/orders/{orderId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
