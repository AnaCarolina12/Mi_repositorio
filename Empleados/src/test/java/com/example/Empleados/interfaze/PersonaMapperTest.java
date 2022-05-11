package com.example.Empleados.interfaze;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Empleados.model.Persona;
import com.example.Empleados.model.PersonaDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PersonaMapperTest {

  private PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);

  @Test
  void PersonaDTO() {
    Persona persona = new Persona("Juan", "el grande");
    PersonaDTO destination = mapper.personaDTOtoPersona(persona);

    assertEquals(persona.getName(), destination.getName());
    assertEquals(persona.getDescription(),
        destination.getDescription());
  }

  @Test
  public void Persona() {
    PersonaDTO destination = new PersonaDTO("Notrami", "el futbolista");
    Persona source = mapper.personatoPersonaDTO(destination);
    assertEquals(destination.getName(), source.getName());
    assertEquals(destination.getDescription(),
        source.getDescription());
  }
}