package com.example.Empleados.interfaze;

import com.example.Empleados.model.SimpleDestination;
import com.example.Empleados.model.SimpleSource;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SimpleSourceDestinationMapper {

  SimpleDestination sourceToDestination(SimpleSource source);

  SimpleSource destinationToSource(SimpleDestination destination);

}
