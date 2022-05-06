package com.example.Empleados.exceptions;

//Esta excepción se activará si el cuerpo de la solicitud no es válido
public class BadRequestException extends RuntimeException {

  public BadRequestException(String message) {
    super(message);
  }

}
