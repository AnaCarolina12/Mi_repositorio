package com.example.Empleados.interfaze;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Empleados.model.Persona;
import com.example.Empleados.model.PersonaDTO;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

class PersonaDestinationMapperTest {

  @Autowired
  private PersonaMapper mapper = Mappers.getMapper(PersonaMapper.class);

  @Test
  void PersonaDTO() {
    Persona persona = new Persona("Juan", "el grande");
    PersonaDTO destination = mapper.personaDTO(persona);

    assertEquals(persona.getName(), destination.getName());
    assertEquals(persona.getDescription(),
        destination.getDescription());
  }

  @Test
  public void Persona() {
    PersonaDTO destination = new PersonaDTO("Notrami", "el futbolista");
    Persona source = mapper.persona(destination);
    assertEquals(destination.getName(), source.getName());
    assertEquals(destination.getDescription(),
        source.getDescription());
  }
}