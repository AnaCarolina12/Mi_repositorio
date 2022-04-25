package com.example.Empleados.controller;

import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.services.EmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EmpleadosController {


    @Autowired
private EmpleadosService empleadosService;

   @RequestMapping("/empleados")
    public List<EmpleadosModel> getAllEmpleados(){

    return  empleadosService.getAllEmpleados();
   }


   @GetMapping("empleados/{dni}")
    public EmpleadosModel getEmpleado(@PathVariable String dni){

       return empleadosService.getEmpleados(dni);

   }


   @PostMapping("/empleados")
    public void addUpdateEmpleados(@RequestBody EmpleadosModel empleadosModel){

       empleadosService.addUpdateEmpleados(empleadosModel);
   }


    @DeleteMapping("/empleados/{dni}")
  public void deleteEmpelados(@PathVariable String dni)  {
       empleadosService.deleteEmpleados(dni);
    }
}
