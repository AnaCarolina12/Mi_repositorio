package com.example.Empleados.controller;

import com.empleados.openapi.model.Empleados;
import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.repository.EmpleadosRepository;
import com.example.Empleados.services.EmpleadosService;
import com.google.common.collect.Collections2;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@WebMvcTest(EmpleadosController.class)



class EmpleadosControllerTest {

    @MockBean
   private EmpleadosService empleadosService;

    @InjectMocks
    private EmpleadosController empleadosController;

    @InjectMocks
 private EmpleadosModel empleadosModel;


 @BeforeEach
 void setUp(){
  MockitoAnnotations.openMocks(this);

 }

 @Test
 void getAllEmpleados() {

  when(empleadosService.getAllEmpleados()).thenReturn(Collections.emptyList());
  List<EmpleadosModel> response = empleadosController.getAllEmpleados();
  assertNotNull(response);
  assertEquals(Collections.emptyList(),response);
 }

    @Test
    void getEmpleado() {

    when(empleadosService.getEmpleados(empleadosModel.getDni())).thenReturn(empleadosModel);
     EmpleadosModel response = empleadosController.getEmpleado(empleadosModel.getDni());
     assertNotNull(response);
     assertEquals(empleadosModel,response);

 }

 @Test
 void addUpdateEmpleados() {

  EmpleadosModel response = empleadosController.addUpdateEmpleados(empleadosModel);
  assertNotNull(response);
  assertEquals(empleadosModel,response);

 }

 @Test
 void deleteEmpleados() {
 }

}