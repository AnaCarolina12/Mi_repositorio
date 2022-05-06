package com.example.Empleados.exceptions;

//Esta excepción se activa cuando no exista ningún elemento en el servidor
public class NoContentException extends RuntimeException {

  public NoContentException(String message) {
    super(message);
  }
}
