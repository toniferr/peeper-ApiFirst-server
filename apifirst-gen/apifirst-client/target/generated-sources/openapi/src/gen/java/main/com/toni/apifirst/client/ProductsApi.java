package com.toni.apifirst.client;

import com.toni.apifirst.ApiClient;

import com.toni.apifirst.model.CategoryDto;
import com.toni.apifirst.model.ProblemDto;

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
public class ProductsApi {
    private ApiClient apiClient;

    public ProductsApi() {
        this(new ApiClient());
    }

    public ProductsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * List Categories
     * List Categories
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @return List&lt;CategoryDto&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<CategoryDto> listCategories() throws RestClientException {
        return listCategoriesWithHttpInfo().getBody();
    }

    /**
     * List Categories
     * List Categories
     * <p><b>200</b> - successful operation
     * <p><b>400</b> - Request was received but was invalid. Check format and content of the request.  See the problem detail for more information.
     * <p><b>404</b> - The requested resource was not found.
     * @return ResponseEntity&lt;List&lt;CategoryDto&gt;&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public ResponseEntity<List<CategoryDto>> listCategoriesWithHttpInfo() throws RestClientException {
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

        ParameterizedTypeReference<List<CategoryDto>> localReturnType = new ParameterizedTypeReference<List<CategoryDto>>() {};
        return apiClient.invokeAPI("/v1/categories", HttpMethod.GET, Collections.<String, Object>emptyMap(), localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarCookieParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localReturnType);
    }
}
