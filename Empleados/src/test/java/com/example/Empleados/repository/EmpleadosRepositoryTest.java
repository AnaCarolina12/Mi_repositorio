package com.example.Empleados.repository;

import com.example.Empleados.model.Empleados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;



class EmpleadosRepositoryTest {
    @Mock
    private EmpleadosRepository empleadosRepository;

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
    void findAll() {

        when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleados));
        assertNotNull(empleadosRepository.findAll());


    }

    @Test
    void findById() {
       // Optional<Empleados> r = empleadosRepository.findById(empleados.getDni());
        when(empleadosRepository.findById(empleados.getDni())).thenReturn(Optional.ofNullable(empleados));

        assertNotNull(empleadosRepository.findById(empleados.getDni()));
    }

    @Test
    void save() {

        //Empleados domar = empleadosRepository.save(empleados);

        when(empleadosRepository.save(empleados)).thenReturn(empleados);

              assertNotNull(empleadosRepository.save(empleados));
        verify(empleadosRepository).deleteById(empleados.getDni());

    }


    @Test
    void deleteById() {



        verify(empleadosRepository).deleteById(empleados.getDni());

    }






}