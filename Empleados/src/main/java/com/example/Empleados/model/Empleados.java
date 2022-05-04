package com.example.Empleados.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "Empleados")
@Data
@AllArgsConstructor
public class Empleados {

@Id
    private String dni;

    private String nombre;

    private String apellidos;

    public Empleados() {

    }
}
