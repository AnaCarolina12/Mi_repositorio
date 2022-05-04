package com.example.Empleados.exception;

public class BadRequestException extends  RuntimeException{

    public BadRequestException(String message) {
        super(message);
    }

}
