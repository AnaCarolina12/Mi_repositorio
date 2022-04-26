package com.example.Empleados.controller;

import com.empleados.openapi.api.EmpleadosApi;
import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.services.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class EmpleadosController implements EmpleadosApi {


    @Autowired
private EmpleadosService empleadosService;

    @Override
    public List<EmpleadosModel> getAllEmpleados(){

    return  empleadosService.getAllEmpleados();
   }

   @Override
    public EmpleadosModel getEmpleado(@PathVariable String dni){

       return empleadosService.getEmpleados(dni);

   }
@Override
    public void addUpdateEmpleados(@RequestBody EmpleadosModel empleadosModel){

        empleadosService.addUpdateEmpleados(empleadosModel);
    }

    @Override
    public void cleanEmpelados(@PathVariable String dni)  {
        empleadosService.cleanEmpleados(dni);
    }
    /*
    No funciona

*/

}
