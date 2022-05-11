package com.example.Empleados.interfaze;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Empleados.model.Persona;
import com.example.Empleados.model.PersonaDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PersonaMapperTest {

  private PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);

  @Test
  void Persona() {
    Persona persona = new Persona("Juan", "el grande");
    PersonaDTO personaDTO = mapper.personatoPersonaDTO(persona);

    assertEquals(persona.getName(), personaDTO.getName());

  }

  @Test
  public void PersonaDTO() {
    PersonaDTO personaDTO = new PersonaDTO("Notrami", "el futbolista");
    Persona persona = mapper.personaDTOtoPersona(personaDTO);
    assertEquals(personaDTO.getName(), persona.getName());
  }
}