package com.example.Empleados.exceptions;

//Esta excepción se activa cuando no encuentre el recurso en el servidor
public class NoSuchElementException extends RuntimeException {

  public NoSuchElementException(String message) {
    super(message);
  }
}
