package com.example.Empleados.controller;

import com.empleados.openapi.model.Empleados;
import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.repository.EmpleadosRepository;
import com.example.Empleados.services.EmpleadosService;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@WebMvcTest(EmpleadosController.class)



class EmpleadosControllerTest {

    @MockBean
    private EmpleadosController empleadosController;
@Mock
 private EmpleadosRepository empleadosRepository;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        EmpleadosModel empleadosModel = new EmpleadosModel();

        empleadosModel.setNombre("Marianza");
        empleadosModel.setApellidos("Juanjo");
        empleadosModel.setDni("12345678P");


    }


    @Test
    void getAllEmpleados() {


    }

    @Test
    void getEmpleado() {
    }

    @Test
    void addUpdateEmpleados() {
    }

    @Test
    void deleteEmpelados() {
        EmpleadosModel empleadosModel = new EmpleadosModel();

        empleadosModel.setNombre("Marianza");
        empleadosModel.setApellidos("Juanjo");
        empleadosModel.setDni("12345678P");
        empleadosController.deleteEmpelados(empleadosModel.getDni());
        verify(empleadosRepository).deleteById(empleadosModel.getDni());
    }
}