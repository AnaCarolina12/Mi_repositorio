package com.example.Empleados.mapper;

import com.example.Empleados.dto.PersonaDTO;
import com.example.Empleados.model.Persona;
import org.mapstruct.Mapper;

@Mapper
public interface PersonaMapper {

  Persona personaDTOtoPersona(PersonaDTO personaDTO);

  PersonaDTO personatoPersonaDTO(Persona persona);

}
