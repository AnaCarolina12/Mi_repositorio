package com.example.Empleados.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Empleados")
@Getter
@Setter
//No funcionan..correctamente
public class Empleados {

  @Id
  public String dni;

  public String nombre;

  public String apellidos;

}
