package com.example.Empleados.controller;

import java.util.List;

import com.empleados.openapi.api.EmpleadosApi;
import com.example.Empleados.mapper.EmpleadosMapper;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadosController implements EmpleadosApi {

  @Autowired
  private EmpleadosServiceImp empleadosServiceImp;

  @Autowired
  private EmpleadosMapper empleadosMapper;

  @Override
  public List<Empleados> getAllEmpleados() {

    return empleadosMapper.toempleadosDTO(
        empleadosServiceImp.getAllEmpleados()
    );

  }

  @Override
  public Empleados getEmpleado(@PathVariable String dni) {

    return empleadosMapper.empleadostoEmpleadosDTO(empleadosServiceImp.getEmpleados(dni));

  }

  @Override
  public Empleados addUpdateEmpleados(@RequestBody Empleados empleados) {

    return
        empleadosMapper.empleadostoEmpleadosDTO(empleadosServiceImp.addUpdateEmpleados(
            empleadosMapper.empleadosDTOtoEmpleados(empleados)));

  }

  @Override
  public void deleteEmpelados(@PathVariable String dni) {

    empleadosServiceImp.deleteEmpleados(dni);
  }
}

