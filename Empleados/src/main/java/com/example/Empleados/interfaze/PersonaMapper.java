package com.example.Empleados.interfaze;

import com.example.Empleados.model.Persona;
import com.example.Empleados.model.PersonaDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PersonaMapper {

  PersonaDTO personaDTOtoPersona(Persona source);

  Persona personatoPersonaDTO(PersonaDTO destination);

}
