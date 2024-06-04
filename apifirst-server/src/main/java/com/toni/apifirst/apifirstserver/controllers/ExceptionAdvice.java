package com.toni.apifirst.apifirstserver.controllers;

import com.toni.apifirst.apifirstserver.controllers.traits.ConstraintViolationExceptionTrait;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.spring.web.advice.ProblemHandling;


@ControllerAdvice
public class ExceptionAdvice implements ConstraintViolationExceptionTrait, ProblemHandling {

}
