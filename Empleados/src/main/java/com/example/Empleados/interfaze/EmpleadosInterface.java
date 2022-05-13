package com.example.Empleados.interfaze;

import java.util.List;

import com.example.Empleados.dto.EmpleadosDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosInterface {

  EmpleadosDTO getEmpleados(String dni);

  List<EmpleadosDTO> getAllEmpleados();

  EmpleadosDTO addUpdateEmpleados(EmpleadosDTO empleadosDTO);

  void deleteEmpleados(String dni);

}
