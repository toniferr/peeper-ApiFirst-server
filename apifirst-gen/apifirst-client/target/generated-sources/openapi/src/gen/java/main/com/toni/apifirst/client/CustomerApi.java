package com.toni.apifirst.client;

import com.toni.apifirst.ApiClient;

import com.toni.apifirst.model.CustomerDto;
import com.toni.apifirst.model.CustomerPatchDto;
import com.toni.apifirst.model.ProblemDto;
import java.net.URI;
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
public class CustomerApi {
    private ApiClient apiClient;

    public CustomerApi() {
        this(new ApiClient());
    }

    public CustomerApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Create a new customer
     * Create a new customer.
     * <p><b>201</b> - Created
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * @param customerDto  (optional)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void createCustomer(CustomerDto customerDto) throws RestClientException {
        createCustomerWithHttpInfo(customerDto);
    }

    /**
     * Create a new customer
     * Create a new customer.
     * <p><b>201</b> - Created
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * @param customerDto  (optional)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> createCustomerWithHttpInfo(CustomerDto customerDto) throws RestClientException {
        Object localVarPostBody = customerDto;
        

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
        return apiClient.invokeAPI("/v1/customers", HttpMethod.POST, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Delete a customer by ID
     * Delete a customer by ID 
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * <p><b>409</b> - Unable to complete request due to a conflict with the current state of the target resource. May be due to constraint violation.
     * @param customerId The ID value of the customer. This value is a UUID. (required)
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public void deleteCustomerById(UUID customerId) throws RestClientException {
        deleteCustomerByIdWithHttpInfo(customerId);
    }

    /**
     * Delete a customer by ID
     * Delete a customer by ID 
     * <p><b>204</b> - No Content
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * <p><b>409</b> - Unable to complete request due to a conflict with the current state of the target resource. May be due to constraint violation.
     * @param customerId The ID value of the customer. This value is a UUID. (required)
     * @return ResponseEntity&lt;Void&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<Void> deleteCustomerByIdWithHttpInfo(UUID customerId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'customerId' when calling deleteCustomerById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("customerId", customerId);

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
        return apiClient.invokeAPI("/v1/customers/{customerId}", HttpMethod.DELETE, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a customer by ID
     * Get a customer by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param customerId The ID value of the customer. This value is a UUID. (required)
     * @return CustomerDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CustomerDto getCustomerById(UUID customerId) throws RestClientException {
        return getCustomerByIdWithHttpInfo(customerId).getBody();
    }

    /**
     * Get a customer by ID
     * Get a customer by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param customerId The ID value of the customer. This value is a UUID. (required)
     * @return ResponseEntity&lt;CustomerDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CustomerDto> getCustomerByIdWithHttpInfo(UUID customerId) throws RestClientException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'customerId' when calling getCustomerById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("customerId", customerId);

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

        ParameterizedTypeReference<CustomerDto> localReturnType = new ParameterizedTypeReference<CustomerDto>() {};
        return apiClient.invokeAPI("/v1/customers/{customerId}", HttpMethod.GET, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Get a list of customers
     * Get a list of customers.
     * <p><b>200</b> - Success
     * <p><b>404</b> - The requested resource was not found.
     * @return List&lt;CustomerDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CustomerDto> listCustomers() throws RestClientException {
        return listCustomersWithHttpInfo().getBody();
    }

    /**
     * Get a list of customers
     * Get a list of customers.
     * <p><b>200</b> - Success
     * <p><b>404</b> - The requested resource was not found.
     * @return ResponseEntity&lt;List&lt;CustomerDto&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<CustomerDto>> listCustomersWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<CustomerDto>> localReturnType = new ParameterizedTypeReference<List<CustomerDto>>() {};
        return apiClient.invokeAPI("/v1/customers", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Patch a customer by ID
     * Patch a customer by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param customerId The ID value of the customer. This value is a UUID. (required)
     * @param customerPatchDto  (optional)
     * @return CustomerDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CustomerDto patchCustomerById(UUID customerId, CustomerPatchDto customerPatchDto) throws RestClientException {
        return patchCustomerByIdWithHttpInfo(customerId, customerPatchDto).getBody();
    }

    /**
     * Patch a customer by ID
     * Patch a customer by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param customerId The ID value of the customer. This value is a UUID. (required)
     * @param customerPatchDto  (optional)
     * @return ResponseEntity&lt;CustomerDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CustomerDto> patchCustomerByIdWithHttpInfo(UUID customerId, CustomerPatchDto customerPatchDto) throws RestClientException {
        Object localVarPostBody = customerPatchDto;
        
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'customerId' when calling patchCustomerById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("customerId", customerId);

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

        ParameterizedTypeReference<CustomerDto> localReturnType = new ParameterizedTypeReference<CustomerDto>() {};
        return apiClient.invokeAPI("/v1/customers/{customerId}", HttpMethod.PATCH, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
    /**
     * Update a customer by ID
     * Update a customer by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param customerId The ID value of the customer. This value is a UUID. (required)
     * @param customerDto  (optional)
     * @return CustomerDto
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public CustomerDto updateCustomerById(UUID customerId, CustomerDto customerDto) throws RestClientException {
        return updateCustomerByIdWithHttpInfo(customerId, customerDto).getBody();
    }

    /**
     * Update a customer by ID
     * Update a customer by ID 
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @param customerId The ID value of the customer. This value is a UUID. (required)
     * @param customerDto  (optional)
     * @return ResponseEntity&lt;CustomerDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<CustomerDto> updateCustomerByIdWithHttpInfo(UUID customerId, CustomerDto customerDto) throws RestClientException {
        Object localVarPostBody = customerDto;
        
        // verify the required parameter 'customerId' is set
        if (customerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing the required parameter 'customerId' when calling updateCustomerById");
        }
        
        // create path and map variables
        final Map<String, Object> uriVariables = new HashMap<String, Object>();
        uriVariables.put("customerId", customerId);

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

        ParameterizedTypeReference<CustomerDto> localReturnType = new ParameterizedTypeReference<CustomerDto>() {};
        return apiClient.invokeAPI("/v1/customers/{customerId}", HttpMethod.PUT, uriVariables, localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
