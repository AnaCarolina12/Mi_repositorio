package com.example.Empleados.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

class HandleExceptionsTest {

  @Mock
  private HandleExceptions handleExceptions;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void NoContentException() {

    NoContentException e = new NoContentException("");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT);

    assertNotNull(errorObject.getMessage());
    assertNotNull(errorObject.getStatusCode());
    assertNotNull(errorObject.getHttpStatus());


  }

  @Test
  void NotFoundException() {

    NotFoundException e = new NotFoundException("");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND);


  }

  @Test
  void BadRequestException() {
    BadRequestException e = new BadRequestException("");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
  }

  @Test
  void HandlerBadRequestException() {

    BadRequestException e = new BadRequestException("Todo mal");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);

    //assertEquals(21, handleExceptions.handlerBadRequestException(e));
    // when(handleExceptions.handlerBadRequestException(e)).thenReturn(null);
    verify(handleExceptions).handlerBadRequestException(e);

  }

  @Test
  void handlerNotFoundException() {

  }

  private ErrorObject getErrorObjectModel(Exception e, Integer statusCode, HttpStatus httpStatus) {

    ErrorObject errorObjectes = new ErrorObject();
    errorObjectes.setMessage(e.getMessage());
    errorObjectes.setHttpStatus(httpStatus);
    errorObjectes.setStatusCode(statusCode);

    return errorObjectes;

  }
}