package com.example.Empleados.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Empleados")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//No funcionan..correctamente
public class Empleados {

  @Id
  public String dni;

  public String nombre;

  public String apellidos;


}
