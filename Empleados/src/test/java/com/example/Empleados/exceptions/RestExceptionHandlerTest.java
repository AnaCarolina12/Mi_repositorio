package com.example.Empleados.exceptions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.Empleados.repository.EmpleadosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

class RestExceptionHandlerTest {

  @Mock
  private EmpleadosRepository empleadosRepository;

  @Autowired
  private MockMvc mvc;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void handlerNoContentException() throws Exception {

    NoContentException e = new NoContentException("dszx");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.NO_CONTENT.value(), HttpStatus.NO_CONTENT);

    assertNotNull(errorObject.getMessage());
    assertNotNull(errorObject.getStatusCode());
    assertNotNull(errorObject.getHttpStatus());

    assertNotNull(errorObject);

  }

  @Test
  void handlerNotFoundException() throws Exception {

    NotFoundException e = new NotFoundException("No existe dicho dni");
    ErrorObject errorObject = getErrorObjectModel(e, HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND);


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