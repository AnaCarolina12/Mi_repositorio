package com.example.Empleados.controller;

import com.empleados.openapi.api.EmpleadosApi;
import com.example.Empleados.models.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmpleadosController implements EmpleadosApi {


    //@Autowired: inyecta unas dependecias con otras.
    //aqui va ha enlazar el servicio con el controler
    @Autowired

private EmpleadosServiceImp empleadosService;


  @Override
    public List<Empleados> getAllEmpleados(){

    return  empleadosService.getAllEmpleados();
   }


    @Override
    public Empleados getEmpleado(@PathVariable String dni){

       return empleadosService.getEmpleados(dni);

   }


    @Override
    public void addUpdateEmpleados(@RequestBody Empleados empleadosModel){

       empleadosService.addUpdateEmpleados(empleadosModel);
   }


    @Override
  public void deleteEmpelados(@PathVariable String dni)  {
       empleadosService.deleteEmpleados(dni);
    }
}
