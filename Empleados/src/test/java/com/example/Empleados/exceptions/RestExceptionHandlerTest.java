package com.example.Empleados.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

class RestExceptionHandlerTest {

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void handlerNoContentException() {

    NoContentException e = new NoContentException("Un dato del empleado esta vacio");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT);

    assertNotNull(errorObject.getMessage());
    assertNotNull(errorObject.getStatusCode());
    assertNotNull(errorObject.getHttpStatus());

    assertNotNull(errorObject);


  }

  @Test
  void handlerNotFoundException() {

    NotFoundException e = new NotFoundException("No existe dicho dni");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND);

    assertNotNull(errorObject);

  }

  @Test
  void handlerBadRequestException() {
    BadRequestException e = new BadRequestException("El dni no cumple con el patron");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);


  }

  private ErrorObject getErrorObjectModel(Exception e, Integer statusCode, HttpStatus httpStatus) {

    ErrorObject errorObjectes = new ErrorObject();
    errorObjectes.setMessage(e.getMessage());
    errorObjectes.setHttpStatus(httpStatus);
    errorObjectes.setStatusCode(statusCode);

    return errorObjectes;

  }
}