package com.example.Empleados.interfaze;

import java.util.List;

import com.example.Empleados.model.Empleados;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosInterface {

  List<Empleados> getAllEmpleados();

  Empleados getEmpleados(String dni);

  Empleados addUpdateEmpleados(Empleados empleados);

  void deleteEmpleados(String dni);

}
