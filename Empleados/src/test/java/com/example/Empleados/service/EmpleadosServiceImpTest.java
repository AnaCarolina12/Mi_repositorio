package com.example.Empleados.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.Empleados.dto.EmpleadosDTO;
import com.example.Empleados.exceptions.BadRequestException;
import com.example.Empleados.exceptions.NoContentException;
import com.example.Empleados.exceptions.NotFoundException;
import com.example.Empleados.mapper.EmpleadosMapper;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmpleadosServiceImpTest {

  @Mock
  private EmpleadosRepository empleadosRepository;

  @InjectMocks
  private EmpleadosServiceImp empleadosServiceImp;

  private EmpleadosMapper empleadosMapper = Mappers.getMapper(EmpleadosMapper.class);

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void getAllEmpleados() {

    Empleados empleados = getEmpleadosModel("11111111P", "Martinez", "Romero");
    Empleados empleados2 = getEmpleadosModel("55567851T", "CarolinaUpdate", "Martinez");

    when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleados, empleados2));
    EmpleadosDTO empleadosDTO = empleadosMapper.empleadosDTOtoEmpleados(empleados);
    EmpleadosDTO empleadosDTO2 = empleadosMapper.empleadosDTOtoEmpleados(empleados2);

    List<EmpleadosDTO> empleadosListDTO = empleadosServiceImp.getAllEmpleados();

    assertNotNull(empleadosListDTO);

  }

  @Test
  void getEmpleados() {

    Empleados empleados = getEmpleadosModel("22222222P", "Martinez", "Romero");

    when(empleadosRepository.findById(empleados.getDni())).thenReturn(Optional.ofNullable(empleados));
    EmpleadosDTO response = empleadosServiceImp.getEmpleados(empleados.getDni());

    assertNotNull(response);
    //assertEquals(empleados.getDni(), response.getDni());

  }

  @Test
  void addUpdateEmpleados() {
    //Creacion de objetos
    Empleados empleados = getEmpleadosModel("33289120T", "Messi", "Cruz");
    EmpleadosDTO l = empleadosMapper.empleadosDTOtoEmpleados(empleados);
    //Definicion de mocikto
    when(empleadosRepository.save(empleados)).thenReturn(empleados);
    //Llamada al metodos
    EmpleadosDTO response = empleadosServiceImp.addUpdateEmpleados(l);
    //comprobaciones
    assertNotNull(empleados);
    //assertEquals(empleados, response);
  }

  @Test
  void deleteEmpleados() {

    Empleados empleados = getEmpleadosModel("55567851T", "CarolinaUpdate", "Martinez");

    when(empleadosRepository.findById(empleados.getDni())).thenReturn(Optional.ofNullable(empleados));
    empleadosServiceImp.deleteEmpleados(empleados.getDni());

    verify(empleadosRepository).deleteById(empleados.getDni());

  }

  @Test
  void ExceptiongetAllEmpleados() {
    assertThrows(
        NotFoundException.class,
        () ->
            empleadosServiceImp.getAllEmpleados());
  }

  @Test
  void ExceptiongetEmpleados() {
    Empleados empleados = getEmpleadosModel("12345678L", "Messi", "Cruz");
    EmpleadosDTO empleadosDTO = empleadosMapper.empleadosDTOtoEmpleados(empleados);
    //Exception que indica que el servidor no puede encontrar el recurso solicitado

    //assertEquals(null, empleadosDTO.getDni());
    assertThrows(
        NoSuchElementException.class,
        () ->
            empleadosServiceImp.getEmpleados("12345678M"));
  }

  @Test
  void ExceptionaddUpdateEmpleados() {
    Empleados empleados = getEmpleadosModel("123456789P", "Messi", "Cruz");
    Empleados empleados2 = getEmpleadosModel("12345678P", "", "Broa");
    Empleados empleados3 = getEmpleadosModel("", "Boris", "Broa");

    EmpleadosDTO empleadosDTO = empleadosMapper.empleadosDTOtoEmpleados(empleados);
    EmpleadosDTO empleadosDTO2 = empleadosMapper.empleadosDTOtoEmpleados(empleados2);
    EmpleadosDTO empleadosDTO3 = empleadosMapper.empleadosDTOtoEmpleados(empleados3);

    //comprobaciones
    //Exception que indica que  el cliente ha cometido un error sintáctico en la llamada
    //por lo que el servidor no puede procesar la peticion
    assertThrows(
        BadRequestException.class,
        () ->
            //Llamada al metodo
            empleadosServiceImp.addUpdateEmpleados(empleadosDTO)
    );

    assertThrows(
        NoContentException.class,
        () ->
            //Llamada al metodo
            empleadosServiceImp.addUpdateEmpleados(empleadosDTO2)
    );

    assertThrows(
        NoContentException.class,
        () ->
            //Llamada al metodo
            empleadosServiceImp.addUpdateEmpleados(empleadosDTO3)
    );


  }

  private Empleados getEmpleadosModel(String dni, String nombre, String apellidos) {
    Empleados empleados = new Empleados();

    empleados.setDni(dni);
    empleados.setNombre(nombre);
    empleados.setApellidos(apellidos);

    return empleados;
  }


}
