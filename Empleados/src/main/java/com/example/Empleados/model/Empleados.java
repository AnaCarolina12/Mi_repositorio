package com.example.Empleados.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "Empleados")
@Data//anotación que genera los getter y setter y la configuracion de atributos(toString,hashcode...)
@AllArgsConstructor//genera un consrtuctor de los paramaetros de una clase
public class Empleados {

    @Id
    private String dni;

    private String nombre;
    private String apellidos;

    public Empleados() {

    }
}
