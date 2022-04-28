package com.example.Empleados.controller;

import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.repository.EmpleadosRepository;
import com.example.Empleados.services.EmpleadosService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
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
    empleadosModel= new EmpleadosModel();

    empleadosModel.setNombre("Marianza");
    empleadosModel.setApellidos("Juanjo");
    empleadosModel.setDni("12345678P");


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
    when(empleadosRepository.save(any(EmpleadosModel.class))).thenReturn(empleadosModel);
    when(empleadosRepository.findById(empleadosModel.getDni())).thenReturn(Optional.ofNullable(empleadosModel));

    }

    @Test
    void deleteEmpelados() {
    when(empleadosRepository.deleteByDni(empleadosModel.getDni())).thenReturn(null);

    }
}