package com.example.Empleados.service;

import com.example.Empleados.model.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class EmpleadosServiceImpTest {

    @Mock
    private EmpleadosRepository empleadosRepository;

    @InjectMocks
    private EmpleadosServiceImp empleadosServiceImp;
    @Autowired
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
        //assertEquals(Collections.emptyList(),Arrays.asList(empleados));

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