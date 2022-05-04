package com.example.Empleados.controller;


import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@WebMvcTest(EmpleadosController.class)



class EmpleadosControllerTest{

    @MockBean
   private EmpleadosServiceImp empleadosServiceImp;

    @InjectMocks
    private EmpleadosController empleadosController;

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

  when(empleadosServiceImp.getAllEmpleados()).thenReturn(Arrays.asList(empleados));
  List<Empleados> response = empleadosController.getAllEmpleados();
  assertNotNull(response);
  assertEquals((Arrays.asList(empleados)),response);
 }
    @Test
    void getEmpleado() {

    when(empleadosServiceImp.getEmpleados(empleados.getDni())).thenReturn(empleados);
     Empleados response = empleadosController.getEmpleado(empleados.getDni());
     assertNotNull(response);
     assertEquals(empleados,response);

 }

 @Test
 void addUpdateEmpleados() {

  when(empleadosServiceImp.addUpdateEmpleados(empleados)).thenReturn(empleados);
     Empleados response=   empleadosController.addUpdateEmpleados(empleados);

  assertNotNull(response);
  assertEquals(empleados,response);


 }

 @Test
 void deleteEmpelados() {
  doNothing().when(empleadosServiceImp).deleteEmpleados(empleados.getDni());
  empleadosController.deleteEmpelados(empleados.getDni());

  verify(empleadosServiceImp,times(1)).deleteEmpleados(empleados.getDni());


 }

}