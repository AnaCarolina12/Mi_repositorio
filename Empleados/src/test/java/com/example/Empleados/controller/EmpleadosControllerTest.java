package com.example.Empleados.controller;


import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;




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

  }

   @Test
   void getAllEmpleados() {

      Empleados empleados = new Empleados();

       empleados.setNombre("Marianza");
       empleados.setApellidos("Juanjo");
       empleados.setDni("12315978T");

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

        Empleados empleados = new Empleados();

        empleados.setDni("11111111T");
        empleados.setNombre("Carolina");
        empleados.setApellidos("Martinez");

        Empleados empleados2 = new Empleados();

        empleados2.setDni("22222222T");
        empleados2.setNombre("Jacob");
        empleados2.setApellidos("Miranda");

    when(empleadosServiceImp.getEmpleados(empleados.getDni())).thenReturn(empleados);
        when(empleadosServiceImp.getEmpleados(empleados2.getDni())).thenReturn(empleados2);

     Empleados response = empleadosController.getEmpleado(empleados2.getDni());
     assertNotNull(response);
     assertEquals(empleados2,response);

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