package com.example.Empleados.service;


import com.example.Empleados.exception.BadRequestException;
import com.example.Empleados.exception.NoContentException;
import com.example.Empleados.exception.NotFoundException;
import com.example.Empleados.interfaze.EmpleadosIn;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service


public class EmpleadosServiceImp implements EmpleadosIn {

    @Autowired
    private EmpleadosRepository empleadosRepository;

    @Override
    public  List<Empleados> getAllEmpleados(){

        List<Empleados> empleadosgetlista=empleadosRepository.findAll();

       if(CollectionUtils.isEmpty(empleadosgetlista))
      {
        throw new NotFoundException("No existe los empleados");
      }

            return  empleadosgetlista;
    }


    @Override
    public Empleados getEmpleados(String dni){

        Optional<Empleados> listar=empleadosRepository.findById(dni);

      if(!listar.isPresent())
      {
          throw new NotFoundException("No existe dicho dni");
      }

        return listar.get();
    }


    @Override
    public Empleados addUpdateEmpleados(Empleados empleados){

        boolean emptyName = StringUtils.isBlank(empleados.getNombre());
        boolean emptySurname = StringUtils.isBlank(empleados.getApellidos());

        boolean emptyDni= StringUtils.isBlank(empleados.getDni());
        boolean expReg = empleados.getDni().matches("[0-9]{8}[A-Z]");

        if(emptyName || emptySurname)
        {
            throw new NoContentException("Un dato del empleado esta vacio");
        }

       else if(emptyDni)
        {
            throw new  NoContentException("El dni del empleado esta vacio");
        }

        else if(!expReg)
        {
            throw new BadRequestException("El dni no cumple con el patron");
        }

        Empleados emp= empleadosRepository.save(empleados);

        return emp;

    }


    @Override
    public void deleteEmpleados(String dni){
        getEmpleados(dni);

        empleadosRepository.deleteById(dni);

    }

}