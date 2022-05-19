package com.example.Empleados.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
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
    //empleadosMapper transformará una lista cualquiera y debe de devolver una lista de empleadosDTO
    when(empleadosMapper.toempleados(anyList())).thenReturn(Arrays.asList(empleadosDTO, empleadosDTO2));

    //llamamos al metodo del injectMocks
    List<EmpleadosDTO> respuesta2 = empleadosServiceImp.getAllEmpleados();

    assertEquals(respuesta2, Arrays.asList(empleadosDTO, empleadosDTO2));

    verify(empleadosRepository).findAll();
    verify(empleadosMapper).toempleados(anyList());

  }

  @Test
  void getEmpleados() {

    Empleados empleados = getEmpleadosModel("22222222P", "Martinez", "Romero");
    EmpleadosDTO empleadosDTO2 = getEmpleadosDTOModel("12345678G", "AnA", "cruz");

    when(empleadosRepository.findById(anyString())).thenReturn(Optional.ofNullable(empleados));
    when(empleadosMapper.empleadosDTOtoEmpleados(any())).thenReturn(empleadosDTO2);

    EmpleadosDTO listar = empleadosServiceImp.getEmpleados(anyString());

    assertEquals(listar, empleadosDTO2);
    verify(empleadosRepository).findById(anyString());
    verify(empleadosMapper).empleadosDTOtoEmpleados(any());
  }

  @Test
  void addUpdateEmpleados() {
    //Creacion de objetos
    Empleados empleados = getEmpleadosModel("33289120T", "Messi", "Cruz");
    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("12345678G", "AnA", "cruz");

    //Definicion de mocikto
    //resuelto
    when(empleadosMapper.empleadostoEmpleadosDTO(any())).thenReturn(empleados);
    when(empleadosRepository.save(any())).thenReturn(empleados);
    when(empleadosMapper.empleadosDTOtoEmpleados(empleadosRepository.save(any()))).thenReturn(empleadosDTO);

    EmpleadosDTO saveEmpleados = empleadosServiceImp.addUpdateEmpleados(empleadosDTO);

    //Comprobación

    assertEquals(saveEmpleados, empleadosDTO);

    verify(empleadosRepository, times(2)).save(any());
    verify(empleadosMapper).empleadostoEmpleadosDTO(empleadosServiceImp.addUpdateEmpleados(empleadosDTO));

  }

  @Test
  void deleteEmpleados() {

    Empleados empleados = getEmpleadosModel("22222222P", "Martinez", "Romero");
    EmpleadosDTO empleadosDTO2 = getEmpleadosDTOModel("12345678G", "AnA", "cruz");

    when(empleadosRepository.findById(anyString())).thenReturn(Optional.ofNullable(empleados));
    when(empleadosMapper.empleadosDTOtoEmpleados(any())).thenReturn(empleadosDTO2);

    empleadosServiceImp.deleteEmpleados(anyString());

    verify(empleadosRepository).deleteById(any());
    verify(empleadosMapper).empleadosDTOtoEmpleados(any());
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
            empleadosServiceImp.getEmpleados(any())
    );

  }

  @Test
  void badRequestExceptionaddUpdateEmpleados() {

    EmpleadosDTO empleadosDTO = getEmpleadosDTOModel("1234567G", "AnA", "cruz");

    assertThrows(
        BadRequestException.class,
        () ->
            //Llamada al metodo
            empleadosServiceImp.addUpdateEmpleados(empleadosDTO)
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

  /*
   A veces queremos burlarnos del comportamiento de cualquier argumento del tipo dado,
   para ello se utiliza los emparejadores de mockito.

Los emparejadores de Mockito son static métodos y llamadas a esos métodos,
 que sustituye a los argumentos durante las llamadas a when y verify.

Cuando no se utiliza comparadores de argumentos, Mockito registra los valores de sus argumentos y los compara con sus métodos.

   when(empleadosMapper.empleadosDTOtoEmpleados(empleadosDTO2)).thenReturn(empleadosDTO2);

   Estos comparadores devuelven valores ficticios (0 o null).

   Cuando se llama a un comparador como any o anyList,
    mockito almacena un objeto de coincidencia que hace que este omita esa verificación de igualdad y aplique la coincidencia de su
    elección
   */

}
