package com.example.Empleados.services;

import com.example.Empleados.controller.EmpleadosController;
import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.repository.EmpleadosRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@WebMvcTest(EmpleadosService.class)
class EmpleadosServiceTest {

    @MockBean
    private EmpleadosRepository empleadosRepository;

    @InjectMocks
    private EmpleadosService empleadosService;
    @InjectMocks
    private EmpleadosModel empleadosModel;

    @InjectMocks
    private EmpleadosController empleadosController;
    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        empleadosModel= new EmpleadosModel();

        empleadosModel.setNombre("Marianza");
        empleadosModel.setApellidos("Juanjo");
        empleadosModel.setDni("12315978T");

    }

    @Test
    void getAllEmpleados() {

        when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleadosModel));
        assertNotNull(empleadosService.getAllEmpleados());

    }

    @Test
    void getEmpleados() {

        when(empleadosRepository.findById(empleadosModel.getDni())).
                thenReturn(Optional.ofNullable(empleadosModel));
        assertNotNull(empleadosService.getEmpleados(empleadosModel.getDni()));
    }

    @Test
    void addUpdateEmpleados(){

        when(empleadosRepository.save(empleadosModel)).thenReturn(empleadosModel);
        assertNotNull(empleadosService.addUpdateEmpleados(empleadosModel));



    }


    @Test
    void deleteEmpleados(){

        when(empleadosRepository.findById(empleadosModel.getDni())).
                thenReturn(Optional.ofNullable(empleadosModel));
       empleadosService.deleteEmpleados(empleadosModel.getDni());

        verify(empleadosRepository).deleteById(empleadosModel.getDni());

    }


}