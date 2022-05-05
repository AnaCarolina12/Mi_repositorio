package com.example.Empleados.repository;

import com.example.Empleados.model.Empleados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;


@DataMongoTest//

class EmpleadosRepositoryTest {
    @Autowired
    private EmpleadosRepository empleadosRepository;

    private Empleados empleados;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        empleados = new Empleados();

        empleados.setDni("33289120T");
        empleados.setNombre("Messi");
        empleados.setApellidos("Cruz");


    }


    @Test
    void findAll() {

        empleadosRepository.save(empleados);
        List<Empleados> empleadosList=  empleadosRepository.findAll();

        assertNotNull(empleadosList);
        //assertEquals("12315978T",empleadosList);



    }

    @Test
    void findById() {


        empleadosRepository.save(empleados);

       Optional<Empleados> empleado = empleadosRepository.findById(empleados.getDni());
        //Empleados empleados2=new Empleados();
        assertNotNull(empleado);
     //assertEquals(null,r.get().getDni());

    }

    @Test
    void save() {

        empleadosRepository.save(empleados);
        Optional<Empleados> empleado = empleadosRepository.findById(empleados.getDni());

        assertNotNull(empleado);
   // assertEquals(null,empleado);



    }


    @Test
    void deleteById() {
    empleadosRepository.save(empleados);
    empleadosRepository.deleteById(empleados.getDni());
        Optional<Empleados> empleado = empleadosRepository.findById(empleados.getDni());

        assertEquals(Optional.empty(),empleado);


    }

}