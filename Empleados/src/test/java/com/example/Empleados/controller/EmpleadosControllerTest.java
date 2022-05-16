package com.example.Empleados.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import com.example.Empleados.dto.EmpleadosDTO;
import com.example.Empleados.mapper.EmpleadosMapper;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmpleadosControllerTest {

  @Mock
  private EmpleadosServiceImp empleadosServiceImp;

  @InjectMocks
  private EmpleadosController empleadosController;

  private EmpleadosMapper empleadosMapper = Mappers.getMapper(EmpleadosMapper.class);

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void getAllEmpleados() {

    EmpleadosDTO empleados = getEmpleadosModel("22222222P", "Martinez", "Romero");
    EmpleadosDTO empleados2 = getEmpleadosModel("33289120T", "Messi", "Cruz");

    when(empleadosServiceImp.getAllEmpleados()).thenReturn(Arrays.asList(empleados, empleados2));
    List<Empleados> respuesta = empleadosController.getAllEmpleados();

    assertNotNull(respuesta);
    //assertEquals(null, respuesta);

  }

  @Test
  void getEmpleado() {

    EmpleadosDTO empleados = getEmpleadosModel("55567851T", "CarolinaUpdate", "Martinez");

    when(empleadosServiceImp.getEmpleados(empleados.getDni())).thenReturn(empleados);
    Empleados respuesta = empleadosController.getEmpleado(empleados.getDni());

    assertNotNull(respuesta);
    // assertEquals(null, respuesta);

  }

  @Test
  void addUpdateEmpleados() {

    EmpleadosDTO empleados = getEmpleadosModel("11111111P", "Martinez", "Romero");

    when(empleadosServiceImp.addUpdateEmpleados(empleados)).thenReturn(empleados);
    Empleados l = empleadosMapper.empleadostoEmpleadosDTO(empleados);

    empleadosController.addUpdateEmpleados(l);
    assertNotNull(l);
    //assertEquals(null, empleadosServiceImp.addUpdateEmpleados(empleados));

  }

  @Test
  void deleteEmpelados() {

    EmpleadosDTO empleados = getEmpleadosModel("11111111P", "Martinez", "Romero");

    empleadosController.deleteEmpelados(empleados.getDni());

    verify(empleadosServiceImp).deleteEmpleados(empleados.getDni());
  }

  private EmpleadosDTO getEmpleadosModel(String dni, String nombre, String apellidos) {
    EmpleadosDTO empleados = new EmpleadosDTO();

    empleados.setDni(dni);
    empleados.setNombreEmpleado(nombre);
    empleados.setApellidos(apellidos);
    return empleados;
  }

}




