package com.example.Empleados.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

//No funcionan..correctamente
public class EmpleadosDTO {

  @Id
  private String dni;

  private String nombreEmpleado;

  private String apellidos;


}
