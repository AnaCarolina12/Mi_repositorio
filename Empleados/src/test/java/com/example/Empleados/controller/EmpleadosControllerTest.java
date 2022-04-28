package com.example.Empleados.controller;

import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.repository.EmpleadosRepository;
import com.example.Empleados.services.EmpleadosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadosControllerTest {

@Mock
private EmpleadosRepository empleadosRepository;

@InjectMocks
private EmpleadosService empleadosService;
private EmpleadosModel empleadosModel;

@BeforeEach
void setUp(){
    MockitoAnnotations.initMocks(this);
    empleadosModel= new EmpleadosModel("12345678P","Juanjo","Marianza");

}
    @Test
    void getAllEmpleados() {
    when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleadosModel));
    assertNotNull(empleadosService.getAllEmpleados());
    }

    @Test
    void getEmpleado() {
    when(empleadosRepository.findById(empleadosModel.getDni())).thenReturn(Optional.ofNullable(empleadosModel));
        assertNotNull(empleadosService.getEmpleados(empleadosModel.getDni()));
    }

    @Test
    void addUpdateEmpleados() {
    }

    @Test
    void cleanEmpelados() {
    }
}