package com.example.Empleados.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmpleadosControllerTest {

  @Mock// crea un objeto mock de una clase o interfaz determinada
  private EmpleadosServiceImp empleadosServiceImp;

  @InjectMocks//inyecta dependencias simuladas en el objeto simulado
  private EmpleadosController empleadosController;

  @Mock
  private EmpleadosMapper empleadosMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void getAllEmpleados() {

    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("22222222P", "Martinez", "Romero");
    EmpleadosDTO empleadosDTO2 = getEmpleadosDTOModel("33289120T", "Messi", "Cruz");

    Empleados empleados = getEmpleadosModel("12345678M", "Ana", "Cruz");
    Empleados empleados2 = getEmpleadosModel("87654321M", "Lorenzo", "Cruz");

    //El mapper tambien se tiene que mockear
    when(empleadosServiceImp.getAllEmpleados()).thenReturn(Arrays.asList(empleadosDTO, empleadosDTO2));
    when(empleadosMapper.toempleadosDTO(anyList())).thenReturn(Arrays.asList(empleados, empleados2));

    //llamamos al metodo del injectMocks
    List<Empleados> respuesta = empleadosController.getAllEmpleados();

    assertEquals(respuesta, Arrays.asList(empleados, empleados2));

    verify(empleadosServiceImp).getAllEmpleados();
    verify(empleadosMapper).toempleadosDTO(anyList());

  }

  @Test
  void getEmpleado() {

    EmpleadosDTO empleados = getEmpleadosDTOModel("55567851T", "CarolinaUpdate", "Martinez");
    Empleados empleados1 = getEmpleadosModel("12345678M", "Ana", "Cruz");

    when(empleadosServiceImp.getEmpleados(anyString())).thenReturn(empleados);
    when(empleadosMapper.empleadostoEmpleadosDTO(any(EmpleadosDTO.class))).thenReturn(empleados1);

    Empleados response = empleadosController.getEmpleado(empleados.getDni());

    assertEquals(response, empleados1);

    verify(empleadosServiceImp).getEmpleados(anyString());
    verify(empleadosMapper).empleadostoEmpleadosDTO(any(EmpleadosDTO.class));
  }

  @Test
  void addUpdateEmpleados() {

    //EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("11111111P", "Martinez", "Romero");
    Empleados empleados1 = getEmpleadosModel("12345678M", "Ana", "Cruz");

    when(empleadosMapper.empleadostoEmpleadosDTO(
        empleadosServiceImp.addUpdateEmpleados(empleadosMapper.empleadosDTOtoEmpleados(any(Empleados.class)))))
        .thenReturn(empleados1);

    Empleados respuesta = empleadosController.addUpdateEmpleados(empleados1);

    assertEquals(respuesta, empleados1);

    verify(empleadosMapper).empleadostoEmpleadosDTO(
        empleadosServiceImp.addUpdateEmpleados(empleadosMapper.empleadosDTOtoEmpleados(any(Empleados.class))));

  }

  @Test
  void deleteEmpelados() {

    EmpleadosDTO empleados = getEmpleadosDTOModel("11111111P", "Martinez", "Romero");
    //doNothing().when(empleadosServiceImp).deleteEmpleados(anyString());
    empleadosController.deleteEmpelados(empleados.getDni());

    verify(empleadosServiceImp).deleteEmpleados(anyString());
  }

  private EmpleadosDTO getEmpleadosDTOModel(String dni, String nombre, String apellidos) {
    EmpleadosDTO empleados = new EmpleadosDTO();

    empleados.setDni(dni);
    empleados.setNombreEmpleado(nombre);
    empleados.setApellidos(apellidos);

    return empleados;
  }

  private Empleados getEmpleadosModel(String dni, String nombre, String apellidos) {
    Empleados empleados = new Empleados();

    empleados.setDni(dni);
    empleados.setNombre(nombre);
    empleados.setApellidos(apellidos);

    return empleados;
  }
}
