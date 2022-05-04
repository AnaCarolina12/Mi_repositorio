package com.example.Empleados.service;

import com.example.Empleados.model.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@WebMvcTest(EmpleadosServiceImp.class)
class EmpleadosServiceImpTest {

    @MockBean
    private EmpleadosRepository empleadosRepository;

    @InjectMocks
    private EmpleadosServiceImp empleadosServiceImp;
    @InjectMocks
    private Empleados empleados;



    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        empleados = new Empleados();

        empleados.setNombre("Marianza");
        empleados.setApellidos("Juanjo");
        empleados.setDni("12315978T");

    }

    @Test
    void getAllEmpleados() {

        when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleados));
        assertNotNull(empleadosServiceImp.getAllEmpleados());

    }

    @Test
    void getEmpleados() {

        when(empleadosRepository.findById(empleados.getDni())).
                thenReturn(Optional.ofNullable(empleados));
        assertNotNull(empleadosServiceImp.getEmpleados(empleados.getDni()));
    }

    @Test
    void addUpdateEmpleados(){

        when(empleadosRepository.save(empleados)).thenReturn(empleados);
        assertNotNull(empleadosServiceImp.addUpdateEmpleados(empleados));



    }


    @Test
    void deleteEmpleados(){

        when(empleadosRepository.findById(empleados.getDni())).
                thenReturn(Optional.ofNullable(empleados));
       empleadosServiceImp.deleteEmpleados(empleados.getDni());

        verify(empleadosRepository).deleteById(empleados.getDni());

    }


}