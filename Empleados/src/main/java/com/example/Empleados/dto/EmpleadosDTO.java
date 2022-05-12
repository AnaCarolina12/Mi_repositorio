package com.example.Empleados.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
//No funcionan
public class EmpleadosDTO {

  @Id
  public String dni;

  public String nombreEmpleado;

  public String apellidos;


}
