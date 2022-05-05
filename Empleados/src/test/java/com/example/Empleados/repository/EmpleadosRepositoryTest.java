package com.example.Empleados.repository;

import com.example.Empleados.model.Empleados;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;


import java.util.List;
import java.util.Optional;



import static org.junit.jupiter.api.Assertions.*;



@DataMongoTest// se utiliza para probar los componentes MongoDB
/*
Las pruebas unitarias no tienen mucho sentido aquí de todos modos,
ya que (generalmente) no se está escribiendo ningún código de implementación nuevo.
Estos ya vienen dados
 */

class EmpleadosRepositoryTest {
    @Autowired
    private EmpleadosRepository empleadosRepository;

    private Empleados empleados;

    @BeforeEach
    /*
    indica que método anotado debe ejecutarse antes de cada invocación del método @Test,
     @RepeatedTest ,  @ParameterizedTest o  @TestFactory en la clase actual.
     */
    void setUp(){
        MockitoAnnotations.openMocks(this);

    }


    @Test
    void findAll() {

        Empleados empleados = new Empleados();

        empleados.setDni("44444444T");
        empleados.setNombre("CarolinaUpdate");
        empleados.setApellidos("Martinez");

        Empleados empleados2 = new Empleados();

        empleados2.setDni("87654321T");
        empleados2.setNombre("Carol");
        empleados2.setApellidos("Martinez");

        empleadosRepository.save(empleados);
        empleadosRepository.save(empleados2);

        List<Empleados> empleadosList=  empleadosRepository.findAll();

        assertNotNull(empleadosList);


    }

    @Test
    void findById() {

        Empleados empleados=new Empleados();
        empleados.setDni("12345978T");
        empleados.setNombre("Menas");
        empleados.setApellidos("Martinez");

        Empleados empleados2=new Empleados();
        empleados2.setDni("12341678T");
        empleados2.setNombre("Lorenzo");
        empleados2.setApellidos("Martinez");


        empleadosRepository.save(empleados);
        empleadosRepository.save(empleados2);

       Empleados response = empleadosRepository.findById(empleados2.getDni()).get();

        assertNotNull(response);
     assertEquals(empleados2,response);

    }

    @Test
    void save() {

        Empleados empleados=new Empleados();
        empleados.setDni("11341678T");
        empleados.setNombre("Menas");
        empleados.setApellidos("Martinez");

        empleadosRepository.save(empleados);
        Optional<Empleados> empleado = empleadosRepository.findById(empleados.getDni());

        assertNotNull(empleado);
   // assertEquals(null,empleado);



    }


    @Test
    void deleteById() {

       Empleados empleados = new Empleados();

        empleados.setDni("33289120T");
        empleados.setNombre("Messi");
        empleados.setApellidos("Cruz");

        empleadosRepository.save(empleados);
        
        empleadosRepository.deleteById(empleados.getDni());
        Optional<Empleados> empleado = empleadosRepository.findById(empleados.getDni());

        assertEquals(Optional.empty(),empleado);


    }

}