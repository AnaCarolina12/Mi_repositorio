package com.example.Empleados.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class EmpleadosServiceImpTest {

  @Mock
  private EmpleadosRepository empleadosRepository;

  @InjectMocks
  private EmpleadosServiceImp empleadosServiceImp;

  @Mock
  private EmpleadosMapper empleadosMapper;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);

  }

  @Test
  void getAllEmpleados() {

    Empleados empleados = getEmpleadosModel("11111111P", "Martinez", "Romero");
    Empleados empleados2 = getEmpleadosModel("55567851T", "CarolinaUpdate", "Martinez");

    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("12345678G", "AnA", "cruz");
    EmpleadosDTO empleadosDTO2 = getEmpleadosDTOModel("12345678G", "AnA", "cruz");

    when(empleadosRepository.findAll()).thenReturn(Arrays.asList(empleados, empleados2));
    when(empleadosMapper.toempleados(Arrays.asList(empleados, empleados2))).thenReturn(Arrays.asList(empleadosDTO, empleadosDTO2));

    List<Empleados> respuesta = empleadosRepository.findAll();
    List<EmpleadosDTO> respuesta2 = empleadosServiceImp.getAllEmpleados();

    assertEquals(respuesta.size(), respuesta2.size());

    verify(empleadosRepository, times(2)).findAll();


  }

  @Test
  void getEmpleados() {

    Empleados empleados = getEmpleadosModel("22222222P", "Martinez", "Romero");
    EmpleadosDTO empleadosDTO2 = getEmpleadosDTOModel("12345678G", "AnA", "cruz");

    when(empleadosRepository.findById(empleados.getDni())).thenReturn(Optional.ofNullable(empleados));
    when(empleadosMapper.empleadosDTOtoEmpleados(empleados)).thenReturn(empleadosDTO2);

    Optional<Empleados> response2 = empleadosRepository.findById(empleados.getDni());
    Optional<EmpleadosDTO> listar = Optional.ofNullable(empleadosServiceImp.getEmpleados(empleados.getDni()));

    assertEquals(listar.isPresent(), response2.isPresent());
    verify(empleadosRepository, times(2)).findById(empleados.getDni());
  }

  @Test
  void addUpdateEmpleados() {
    //Creacion de objetos
    Empleados empleados = getEmpleadosModel("33289120T", "Messi", "Cruz");
    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("12345678G", "AnA", "cruz");

    //Definicion de mocikto
    when(empleadosRepository.save(empleados)).thenReturn(empleados);
    when(empleadosMapper.empleadosDTOtoEmpleados(empleados)).thenReturn(empleadosDTO);

    Empleados saveemp2 = empleadosRepository.save(empleados);
    EmpleadosDTO saveEmpleados = empleadosServiceImp.addUpdateEmpleados(empleadosDTO);

    assertEquals(Optional.of(saveEmpleados).isPresent(), Optional.of(saveemp2).isPresent());

    verify(empleadosRepository).save(empleados);
    verify(empleadosMapper, times(2)).empleadostoEmpleadosDTO(empleadosServiceImp.addUpdateEmpleados(empleadosDTO));

  }

  @Test
  void deleteEmpleados() {

    Empleados empleados = getEmpleadosModel("22222222P", "Martinez", "Romero");
    EmpleadosDTO empleadosDTO2 = getEmpleadosDTOModel("12345678G", "AnA", "cruz");

    when(empleadosRepository.findById(empleados.getDni())).thenReturn(Optional.ofNullable(empleados));
    when(empleadosMapper.empleadosDTOtoEmpleados(empleados)).thenReturn(empleadosDTO2);

    empleadosServiceImp.deleteEmpleados(empleados.getDni());
    verify(empleadosRepository).deleteById(empleados.getDni());
  }

  @Test
  void notFoundexceptiongetAllEmpleados() {
    assertThrows(
        NotFoundException.class,
        () ->
            empleadosServiceImp.getAllEmpleados());
  }

  @Test
  void noSuchElementexceptiongetEmpleado() {

    assertThrows(
        NoSuchElementException.class,
        () ->
            empleadosServiceImp.getEmpleados("1234567M")
    );

  }

  @Test
  void badRequestExceptionaddUpdateEmpleados() {

    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("1234567G", "AnA", "cruz");

    assertThrows(
        BadRequestException.class,
        () ->
            //Llamada al metodo
            empleadosMapper.empleadostoEmpleadosDTO(empleadosServiceImp.addUpdateEmpleados(empleadosDTO))
    );


  }

  @Test
  void noContentNameExceptionddUpdateEmpleados() {

    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("12345678G", "", "cruz");

    assertThrows(
        NoContentException.class,
        () ->
            //Llamada al metodo
            empleadosServiceImp.addUpdateEmpleados(empleadosDTO)
    );

  }

  @Test
  void noContentSurnameExceptionddUpdateEmpleados() {

    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("12345678G", "Bria", "");
    assertThrows(
        NoContentException.class,
        () ->
            //Llamada al metodo
            empleadosServiceImp.addUpdateEmpleados(empleadosDTO)
    );
  }

  @Test
  void noContentDniExceptionddUpdateEmpleados() {

    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("", "Bria", "Cruz");

    assertThrows(
        NoContentException.class,
        () ->
            //Llamada al metodo
            empleadosServiceImp.addUpdateEmpleados(empleadosDTO)
    );
  }

  private Empleados getEmpleadosModel(String dni, String nombre, String apellidos) {
    Empleados empleados = new Empleados();

    empleados.setDni(dni);
    empleados.setNombre(nombre);
    empleados.setApellidos(apellidos);

    return empleados;
  }

  private EmpleadosDTO getEmpleadosDTOModel(String dni, String nombre, String apellidos) {
    EmpleadosDTO empleados = new EmpleadosDTO();

    empleados.setDni(dni);
    empleados.setNombreEmpleado(nombre);
    empleados.setApellidos(apellidos);

    return empleados;
  }


}
