package com.example.Empleados.model;

public class PersonaDTO {

  private String name;

  private String description;

  public PersonaDTO(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public PersonaDTO() {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
