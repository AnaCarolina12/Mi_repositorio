package com.example.Empleados.interfaze;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Empleados.model.SimpleDestination;
import com.example.Empleados.model.SimpleSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class SimpleSourceDestinationMapperTest {

  @Autowired
  private SimpleSourceDestinationMapper mapper;

  @Test
  public void givenSourceToDestination_whenMaps_thenCorrect() {
    SimpleSource simpleSource = new SimpleSource("SourceName", "SourceDescription");
    SimpleDestination destination = mapper.sourceToDestination(simpleSource);

    assertEquals(simpleSource.getName(), destination.getName());
    assertEquals(simpleSource.getDescription(),
        destination.getDescription());
  }
}