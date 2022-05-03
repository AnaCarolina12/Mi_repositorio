package com.example.Empleados.exceptions;

public class BadRequestException extends  RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }

}
