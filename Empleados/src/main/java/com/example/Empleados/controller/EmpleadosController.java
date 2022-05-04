package com.example.Empleados.controller;


import com.empleados.openapi.api.EmpleadosApi;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmpleadosController implements EmpleadosApi {


    @Autowired
private EmpleadosServiceImp empleadosServiceImp;

   @Override
    public List<Empleados> getAllEmpleados(){

    return  empleadosServiceImp.getAllEmpleados();
   }


   @Override
    public Empleados getEmpleado(@PathVariable String dni){

       return empleadosServiceImp.getEmpleados(dni);

   }


   @Override
    public Empleados addUpdateEmpleados(@RequestBody Empleados empleados){

   return empleadosServiceImp.addUpdateEmpleados(empleados);
   }


    @Override
  public void deleteEmpelados(@PathVariable String dni)  {
       empleadosServiceImp.deleteEmpleados(dni);
    }
}
