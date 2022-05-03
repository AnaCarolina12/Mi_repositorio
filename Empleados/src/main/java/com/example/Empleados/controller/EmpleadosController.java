package com.example.Empleados.controller;


import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.services.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmpleadosController {


    //@Autowired: inyecta unas dependecias con otras.
    //aqui va ha enlazar el servicio con el controler
    @Autowired

private EmpleadosService empleadosService;

   @GetMapping("/emp")
    public List<EmpleadosModel> getAllEmpleados(){

    return  empleadosService.getAllEmpleados();
   }


   @GetMapping("emp/{dni}")
    public EmpleadosModel getEmpleado(@PathVariable String dni){

       return empleadosService.getEmpleados(dni);

   }


   @PostMapping("/emp")
    public void addUpdateEmpleados(@RequestBody EmpleadosModel empleadosModel){

       empleadosService.addUpdateEmpleados(empleadosModel);
   }


    @DeleteMapping("/emp/{dni}")
  public void deleteEmpelados(@PathVariable String dni)  {
       empleadosService.deleteEmpleados(dni);
    }
}
