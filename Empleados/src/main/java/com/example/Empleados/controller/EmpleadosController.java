package com.example.Empleados.controller;

import com.example.Empleados.models.Empleados;
import com.example.Empleados.service.EmpleadosServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmpleadosController {


    //@Autowired: inyecta unas dependecias con otras.
    //aqui va ha enlazar el servicio con el controler
    @Autowired

private EmpleadosServiceImp empleadosService;

   @GetMapping("/emp")
    public List<Empleados> getAllEmpleados(){

    return  empleadosService.getAllEmpleados();
   }


   @GetMapping("emp/{dni}")
    public Empleados getEmpleado(@PathVariable String dni){

       return empleadosService.getEmpleados(dni);

   }


   @PostMapping("/emp")
    public void addUpdateEmpleados(@RequestBody Empleados empleadosModel){

       empleadosService.addUpdateEmpleados(empleadosModel);
   }


    @DeleteMapping("/emp/{dni}")
  public void deleteEmpelados(@PathVariable String dni)  {
       empleadosService.deleteEmpleados(dni);
    }
}
