package com.example.Empleados.controller;

import java.util.List;

import com.example.Empleados.mapper.EmpleadosMapper;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadosController {

  @Autowired//conecta componentes con otros
  private EmpleadosServiceImp empleadosServiceImp;

  private EmpleadosMapper empleadosMapper;

  @GetMapping("/empleados")
  public List<Empleados> getAllEmpleados() {

    return empleadosServiceImp.getAllEmpleados();
    //empleadosMapper.ListProductDTOs(empleadosServiceImp.getAllEmpleados());

  }

  //@GetMapping("/empleados/{dni}")
  public Empleados getEmpleado(@PathVariable String dni) {

    return empleadosServiceImp.getEmpleados(dni);

  }

  //@PostMapping("/empleados")
  public Empleados addUpdateEmpleados(@RequestBody Empleados empleados) {

    return empleadosServiceImp.addUpdateEmpleados(empleados);
  }

  //@DeleteMapping("/empleados/{dni}")
  public void deleteEmpelados(@PathVariable String dni) {
    empleadosServiceImp.deleteEmpleados(dni);
  }
}

