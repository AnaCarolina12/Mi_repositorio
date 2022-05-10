package com.example.Empleados.controller;

import java.util.List;

import com.empleados.openapi.api.EmpleadosApi;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadosController implements EmpleadosApi {

  @Autowired//conecta componentes con otros
  private EmpleadosServiceImp empleadosServiceImp;

  @GetMapping("/empleados")
  public List<Empleados> getAllEmpleados() {

    return empleadosServiceImp.getAllEmpleados();
  }

  @GetMapping("/empleados/{dni}")
  public Empleados getEmpleado(@PathVariable String dni) {

    return empleadosServiceImp.getEmpleados(dni);

  }

  @PostMapping("/empleados")
  public Empleados addUpdateEmpleados(@RequestBody Empleados empleados) {

    return empleadosServiceImp.addUpdateEmpleados(empleados);
  }

  @DeleteMapping("/empleados/{dni}")
  public void deleteEmpelados(@PathVariable String dni) {
    empleadosServiceImp.deleteEmpleados(dni);
  }
}
