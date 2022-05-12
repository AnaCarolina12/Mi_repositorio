package com.example.Empleados.mapper;

import java.util.List;

import com.example.Empleados.dto.EmpleadosDTO;
import com.example.Empleados.model.Empleados;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmpleadosMapper {

  //cuando haga el mapeo de la propiedad nombre, tome del parametro dto la propiedad nombreEmpleado
  //para asignarla

  @Mapping(target = "nombre", source = "nombreEmpleado")
  Empleados empleadostoEmpleadosDTO(EmpleadosDTO empleadosDTO);

  @Mapping(target = "nombreEmpleado", source = "nombre")
  EmpleadosDTO empleadosDTOtoEmpleados(Empleados empleados);

  List<EmpleadosDTO> ListProductDTOs(List<Empleados> products);

}
