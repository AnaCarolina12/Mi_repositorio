package com.example.Empleados.models;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "Empleados")
// @Data: anotacion que genera @ToString,
// @EqualsAndHashCode, @Getter / @Setter y @RequiredArgsConstructor de un objeto.
@Data
public class Empleados {
//@Id anotación para especificar la clave principal
@Id
    private String dni;

    private String nombre;

    private String apellidos;


}
