package com.example.Empleados.service;

import com.example.Empleados.exceptions.NoContentException;
import com.example.Empleados.exceptions.NotFoundException;
import com.example.Empleados.exceptions.BadRequestException;
import com.example.Empleados.interfaze.EmpleadosIn;
import com.example.Empleados.models.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.*;

@Service

public class EmpleadosServiceImp {

    @Autowired
    private EmpleadosRepository empleadosRepository;


    public  List<Empleados> getAllEmpleados(){

        List<Empleados> empleadosgetlista=empleadosRepository.findAll();

       if(CollectionUtils.isEmpty(empleadosgetlista))
      {
        throw new NotFoundException("No hay ningún empleado");
      }

            return  empleadosgetlista;
    }



    public Empleados getEmpleados(String dni){

        Optional<Empleados> listar=empleadosRepository.findById(dni);

      if(!listar.isPresent())
      {
          throw new NotFoundException("No existe dicho dni");
      }

        return listar.get();
    }



    public void addUpdateEmpleados(Empleados empleadosModel){

        //La clase java.lang.String ofrece un conjunto limitado de métodos String.
        boolean emptyName = StringUtils.isBlank(empleadosModel.getNombre());
        boolean emptySurname = StringUtils.isBlank(empleadosModel.getApellidos());
        boolean emptyDni= StringUtils.isBlank(empleadosModel.getDni());

        boolean expReg = empleadosModel.getDni().matches("[0-9]{8}[A-Z]");
        if(emptyName || emptySurname)
        {
            throw new NoContentException("Un dato del empleado esta vacio");
        }

       else if(emptyDni)
        {
            throw new NoContentException("El campo dni está vacio");
        }

        else if(!expReg)
        {
            throw new BadRequestException("El dni no cumple con el patron");
        }

        empleadosRepository.save(empleadosModel);

    }



    public void deleteEmpleados(String dni){

            getEmpleados(dni);

            empleadosRepository.deleteById(dni);
    }

}
