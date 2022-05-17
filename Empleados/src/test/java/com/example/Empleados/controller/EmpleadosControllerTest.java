package com.example.Empleados.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.Empleados.dto.EmpleadosDTO;
import com.example.Empleados.mapper.EmpleadosMapper;
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

  @Mock
  private EmpleadosMapper empleadosMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void getAllEmpleados() {

    EmpleadosDTO empleadosDTO = getEmpleadosModel("22222222P", "Martinez", "Romero");
    EmpleadosDTO empleadosDTO2 = getEmpleadosModel("33289120T", "Messi", "Cruz");

    Empleados empleados = new Empleados("12345678M", "Ana", "Cruz");
    Empleados empleados2 = new Empleados("87654321M", "Lorenzo", "Cruz");

    //El mapper tambien se tiene que mockear
    when(empleadosServiceImp.getAllEmpleados()).thenReturn(Arrays.asList(empleadosDTO, empleadosDTO2));
    when(empleadosMapper.toempleadosDTO(Arrays.asList(empleadosDTO, empleadosDTO2))).thenReturn(Arrays.asList(empleados, empleados2));

    List<Empleados> respuesta = empleadosController.getAllEmpleados();
    List<EmpleadosDTO> respuesta2 = empleadosServiceImp.getAllEmpleados();

    assertEquals(respuesta2.size(), respuesta.size());

  }

  @Test
  void getEmpleado() {

    EmpleadosDTO empleados = getEmpleadosModel("55567851T", "CarolinaUpdate", "Martinez");
    Empleados empleados1 = new Empleados("12345678M", "Ana", "Cruz");

    when(empleadosServiceImp.getEmpleados(empleados.getDni())).thenReturn(empleados);
    when(empleadosMapper.empleadostoEmpleadosDTO(empleados)).thenReturn(empleados1);

    Empleados respuesta = empleadosController.getEmpleado(empleados.getDni());
    Optional<EmpleadosDTO> respuesta2 = Optional.ofNullable(empleadosServiceImp.getEmpleados(empleados.getDni()));

    assertEquals(respuesta2.isPresent(), Optional.of(respuesta).isPresent());

  }

  @Test
  void addUpdateEmpleados() {

    EmpleadosDTO empleados = getEmpleadosModel("11111111P", "Martinez", "Romero");
    Empleados empleados1 = new Empleados("12345678M", "Ana", "Cruz");

    when(empleadosController.addUpdateEmpleados(empleados1)).thenReturn(empleados1);
    when(empleadosServiceImp.addUpdateEmpleados(empleados)).thenReturn(empleados);

    Empleados response = empleadosController.addUpdateEmpleados(empleados1);
    EmpleadosDTO response2 = empleadosServiceImp.addUpdateEmpleados(empleados);

    assertEquals(Optional.of(response).isPresent(), Optional.of(response2).isPresent());

    verify(empleadosServiceImp).addUpdateEmpleados(empleados);

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
