package com.example.Empleados.service;

import com.example.Empleados.model.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;



import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class EmpleadosServiceImpTest {

    @Mock
    private EmpleadosRepository empleadosRepository;

    @InjectMocks
    private EmpleadosServiceImp empleadosServiceImp;

    private Empleados empleados;



    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    void getAllEmpleados() {
        Empleados empleados = new Empleados();

        empleados.setDni("44444444T");
        empleados.setNombre("CarolinaUpdate");
        empleados.setApellidos("Martinez");

        Empleados empleados2 = new Empleados();

        empleados2.setDni("11111111T");
        empleados2.setNombre("Carolina");
        empleados2.setApellidos("Martinez");

        when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleados,empleados2));
        assertNotNull(empleadosServiceImp.getAllEmpleados());
        List<Empleados> response = empleadosServiceImp.getAllEmpleados();
        assertEquals(Arrays.asList(empleados,empleados2),response);

    }

    @Test
    void getEmpleados() {

        Empleados empleados = new Empleados();

        empleados.setDni("44444444T");
        empleados.setNombre("CarolinaUpdate");
        empleados.setApellidos("Martinez");

        Empleados empleados2 = new Empleados();

        empleados2.setDni("11111111T");
        empleados2.setNombre("Carolina");
        empleados2.setApellidos("Martinez");


        when(empleadosRepository.findById(empleados2.getDni())).
                thenReturn(Optional.ofNullable(empleados2));
        Empleados response = empleadosServiceImp.getEmpleados(empleados2.getDni());

        assertNotNull(empleadosServiceImp.getEmpleados(empleados2.getDni()));
        assertEquals(empleados2,response);
    }

    @Test
    void addUpdateEmpleados(){

      Empleados  empleados = new Empleados();

        empleados.setNombre("Marianza");
        empleados.setApellidos("Juanjo");
        empleados.setDni("12315978T");

        when(empleadosRepository.save(empleados)).thenReturn(empleados);
        Empleados response = empleadosServiceImp.addUpdateEmpleados(empleados);

        assertNotNull(empleadosServiceImp.addUpdateEmpleados(empleados));
        assertEquals(empleados,response);
    }


    @Test
    void deleteEmpleados(){

        Empleados empleados = new Empleados();

        empleados.setDni("44444444T");
        empleados.setNombre("CarolinaUpdate");
        empleados.setApellidos("Martinez");


        when(empleadosRepository.findById(empleados.getDni())).
                thenReturn(Optional.ofNullable(empleados));

       empleadosServiceImp.deleteEmpleados(empleados.getDni());

        verify(empleadosRepository).deleteById(empleados.getDni());

    }


}