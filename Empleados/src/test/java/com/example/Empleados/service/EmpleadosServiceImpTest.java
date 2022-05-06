package com.example.Empleados.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.example.Empleados.model.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmpleadosServiceImpTest {

  @Mock
  private EmpleadosRepository empleadosRepository;

  @InjectMocks
  private EmpleadosServiceImp empleadosServiceImp;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void getAllEmpleados() {
    Empleados empleados = getEmpleadosModel("11111111P", "Martinez", "Romero");
    Empleados empleados2 = getEmpleadosModel("55567851T", "CarolinaUpdate", "Martinez");

    when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleados, empleados2));
    List<Empleados> response = empleadosServiceImp.getAllEmpleados();

    assertNotNull(response);
    assertEquals(Arrays.asList(empleados, empleados2), response);

  }

  @Test
  void getEmpleados() {

    Empleados empleados = getEmpleadosModel("22222222P", "Martinez", "Romero");

    when(empleadosRepository.findById(empleados.getDni())).thenReturn(Optional.ofNullable(empleados));
    Empleados response = empleadosServiceImp.getEmpleados(empleados.getDni());

    assertNotNull(response);
    assertEquals(empleados, response);
  }

  @Test
  void addUpdateEmpleados() {
    //Creacion de objetos
    Empleados empleados = getEmpleadosModel("33289120T", "Messi", "Cruz");
    //Definicion de mocikto
    when(empleadosRepository.save(empleados)).thenReturn(empleados);
    //Llamada al metodos
    Empleados response = empleadosServiceImp.addUpdateEmpleados(empleados);
    //comprobaciones
    assertNotNull(response);
    assertEquals(empleados, response);
  }

  @Test
  void deleteEmpleados() {

    Empleados empleados = getEmpleadosModel("55567851T", "CarolinaUpdate", "Martinez");

    when(empleadosRepository.findById(empleados.getDni())).thenReturn(Optional.ofNullable(empleados));
    empleadosServiceImp.deleteEmpleados(empleados.getDni());

    verify(empleadosRepository).deleteById(empleados.getDni());

  }

  private Empleados getEmpleadosModel(String dni, String nombre, String apellidos) {
    Empleados empleados = new Empleados();

    empleados.setDni(dni);
    empleados.setNombre(nombre);
    empleados.setApellidos(apellidos);
    
    return empleados;
  }


}