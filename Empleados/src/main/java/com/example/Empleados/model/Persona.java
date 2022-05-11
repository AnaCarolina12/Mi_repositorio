package com.example.Empleados.model;

public class Persona {

  private String name;

  private String description;

  public Persona(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Persona() {

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
