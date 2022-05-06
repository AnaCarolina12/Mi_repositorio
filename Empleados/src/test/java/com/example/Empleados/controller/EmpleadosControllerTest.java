package com.example.Empleados.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmpleadosControllerTest {

  @Mock
  private EmpleadosServiceImp empleadosServiceImp;

  @InjectMocks
  private EmpleadosController empleadosController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void getAllEmpleados() {

    Empleados empleados = getEmpleadosModel("22222222P", "Martinez", "Romero");
    Empleados empleados2 = getEmpleadosModel("33289120T", "Messi", "Cruz");

    when(empleadosServiceImp.getAllEmpleados()).thenReturn(Arrays.asList(empleados, empleados2));
    List<Empleados> response = empleadosController.getAllEmpleados();
    assertNotNull(response);

    assertEquals(response, Arrays.asList(empleados, empleados2));

  }

  @Test
  void getEmpleado() {

    Empleados empleados = getEmpleadosModel("55567851T", "CarolinaUpdate", "Martinez");

    when(empleadosServiceImp.getEmpleados(empleados.getDni())).thenReturn(empleados);
    Empleados response = empleadosController.getEmpleado(empleados.getDni());

    assertNotNull(response);
    assertEquals(empleados, response);

  }

  @Test
  void addUpdateEmpleados() {

    Empleados empleados = getEmpleadosModel("11111111P", "Martinez", "Romero");

    when(empleadosServiceImp.addUpdateEmpleados(empleados)).thenReturn(empleados);
    Empleados response = empleadosController.addUpdateEmpleados(empleados);

    assertNotNull(response);
    assertEquals(empleados, response);


  }

  @Test
  void deleteEmpelados() {

    Empleados empleados = getEmpleadosModel("11111111P", "Martinez", "Romero");

    empleadosController.deleteEmpelados(empleados.getDni());

    verify(empleadosServiceImp).deleteEmpleados(empleados.getDni());
  }

  private Empleados getEmpleadosModel(String dni, String nombre, String apellidos) {
    Empleados empleados = new Empleados();

    empleados.setDni(dni);
    empleados.setNombre(nombre);
    empleados.setApellidos(apellidos);
    return empleados;
  }

}