package com.example.Empleados.controller;


import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;



import java.util.Arrays;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



class EmpleadosControllerTest{

    @Mock
   private EmpleadosServiceImp empleadosServiceImp;

    @InjectMocks
    private EmpleadosController empleadosController;


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
   void getAllEmpleados() {
   Empleados empleados2 = new Empleados();

       empleados2.setDni("33289120T");
       empleados2.setNombre("Messi");
       empleados2.setApellidos("Cruz");

    when(empleadosServiceImp.getAllEmpleados()).thenReturn(Arrays.asList(empleados,empleados2));
    List<Empleados> response = empleadosController.getAllEmpleados();
    assertNotNull(response);

    assertEquals(response,Arrays.asList(empleados,empleados2));

   }
    @Test
    void getEmpleado() {

        Empleados empleados2 = new Empleados();

        empleados2.setDni("11111111T");
        empleados2.setNombre("Carolina");
        empleados2.setApellidos("Martinez");

        Empleados empleados3 = new Empleados();

        empleados3.setDni("22222222T");
        empleados3.setNombre("Jacob");
        empleados3.setApellidos("Miranda");

    when(empleadosServiceImp.getEmpleados(empleados3.getDni())).thenReturn(empleados3);
        when(empleadosServiceImp.getEmpleados(empleados2.getDni())).thenReturn(empleados2);

     Empleados response = empleadosController.getEmpleado(empleados3.getDni());
     assertNotNull(response);
     assertEquals(empleados3,response);

 }

   @Test
   void addUpdateEmpleados() {

       Empleados empleados = new Empleados();

       empleados.setDni("44444444T");
       empleados.setNombre("CarolinaUpdate");
       empleados.setApellidos("Martinez");


    when(empleadosServiceImp.addUpdateEmpleados(empleados)).thenReturn(empleados);

       Empleados response=empleadosController.addUpdateEmpleados(empleados);

    assertNotNull(response);
       assertEquals(empleados,response);


   }

   @Test
   void deleteEmpelados() {

       Empleados empleados = new Empleados();

       empleados.setDni("44444444T");
       empleados.setNombre("CarolinaUpdate");
       empleados.setApellidos("Martinez");

    //doNothing().when(empleadosServiceImp).deleteEmpleados(empleados.getDni());
    empleadosController.deleteEmpelados(empleados.getDni());

    verify(empleadosServiceImp).deleteEmpleados(empleados.getDni());


   }

}