package com.example.Empleados.services;

import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.repository.EmpleadosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


class EmpleadosServiceTest {

    @MockBean
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
    void getEmpleados() {
        when(empleadosRepository.findById(empleadosModel.getDni())).thenReturn(Optional.ofNullable(empleadosModel));
        assertNotNull(empleadosService.getEmpleados(empleadosModel.getDni()));
    }



}