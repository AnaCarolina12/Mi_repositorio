package com.example.Empleados.exception;
//Esta excepción se activa cuando no encuentre el recurso en el servidor
public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
