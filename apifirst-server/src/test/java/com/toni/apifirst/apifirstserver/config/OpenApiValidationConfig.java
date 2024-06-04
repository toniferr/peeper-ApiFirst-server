//package com.toni.apifirst.apifirstserver.config;
//
//import com.atlassian.oai.validator.OpenApiInteractionValidator;
//import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter;
//import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor;
//import jakarta.servlet.Filter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class OpenApiValidationConfig {
//
//    @Bean
//    public Filter validationFilter() {
//
//        return new OpenApiValidationFilter(
//                true, // enable request validation
//                true  // enable response validation
//        );
//    }
//
//    @Bean
//    public WebMvcConfigurer openAPIValidationInterceptor() {
//
//        OpenApiInteractionValidator validator = OpenApiInteractionValidator.createForSpecificationUrl("https://api.redocly.com/registry/bundle/toniferr/API%20First%20with%20springboot/v1/openapi.yaml?branch=develop")
//                .build();
//
//        OpenApiValidationInterceptor interceptor = new OpenApiValidationInterceptor(validator);
//
//        return new WebMvcConfigurer() {
//
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(interceptor);
//            }
//        };
//    }
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
