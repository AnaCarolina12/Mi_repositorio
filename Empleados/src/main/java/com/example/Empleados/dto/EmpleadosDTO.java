package com.example.Empleados.dto;

import org.springframework.data.annotation.Id;

/*
@Getter
@Setter
 */

//No funcionan..correctamente
public class EmpleadosDTO {

  @Id
  public String dni;

  public String nombreEmpleado;

  public String apellidos;

  public EmpleadosDTO(String dni, String nombreEmpleado, String apellidos) {
    this.dni = dni;
    this.nombreEmpleado = nombreEmpleado;
    this.apellidos = apellidos;
  }

  public EmpleadosDTO() {

  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombreEmpleado() {
    return nombreEmpleado;
  }

  public void setNombreEmpleado(String nombreEmpleado) {
    this.nombreEmpleado = nombreEmpleado;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }
}
