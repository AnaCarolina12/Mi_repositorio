package com.example.Empleados.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Empleados")
/*@Getter
@Setter

 */
//No funcionan..correctamente
public class Empleados {

  @Id
  public String dni;

  public String nombre;

  public String apellidos;

  public Empleados(String dni, String nombre, String apellidos) {
    this.dni = dni;
    this.nombre = nombre;
    this.apellidos = apellidos;
  }

  public Empleados() {

  }

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }
}
