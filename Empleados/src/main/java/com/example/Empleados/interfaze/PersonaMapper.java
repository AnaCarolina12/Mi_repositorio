package com.example.Empleados.interfaze;

import com.example.Empleados.model.Persona;
import com.example.Empleados.model.PersonaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface PersonaMapper {

  PersonaDTO personaDTO(Persona source);

  Persona persona(PersonaDTO destination);

}
