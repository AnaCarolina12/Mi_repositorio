package com.example.Empleados.Test;

import com.example.Empleados.controller.EmpleadosController;
import com.example.Empleados.services.EmpleadosService;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(EmpleadosController.class)
public class EmpleadosControllerTest {

@MockBean
    private EmpleadosService empleadosService;
@Test

    public void getEmpladosTest(){

    when(empleadosService.getAllEmpleados()).thenReturn()
}



}
