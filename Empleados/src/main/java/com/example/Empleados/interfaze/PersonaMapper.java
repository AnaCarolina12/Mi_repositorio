package com.example.Empleados.interfaze;

import com.example.Empleados.model.Persona;
import com.example.Empleados.model.PersonaDTO;
import org.mapstruct.Mapper;

@Mapper
public interface PersonaMapper {

  Persona personaDTOtoPersona(PersonaDTO personaDTO);

  PersonaDTO personatoPersonaDTO(Persona persona);

}
