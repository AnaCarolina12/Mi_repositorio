package com.example.Empleados.services;

import com.example.Empleados.exceptions.NoContentException;
import com.example.Empleados.exceptions.NotFoundException;
import com.example.Empleados.exceptions.BadRequestException;
import com.example.Empleados.models.EmpleadosModel;
import com.example.Empleados.repository.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


import java.util.*;

@Service

public class EmpleadosService {

    private EmpleadosRepository empleadosRepository;

    public  List<EmpleadosModel> getAllEmpleados(){

        List<EmpleadosModel> empleadosgetlista=empleadosRepository.findAll();

       if(CollectionUtils.isEmpty(empleadosgetlista))
      {
        throw new NotFoundException("No hay ningún empleado");
      }

            return  empleadosgetlista;
    }


    public EmpleadosModel getEmpleados(String dni){

        Optional<EmpleadosModel> listar=empleadosRepository.findById(dni);

      if(!listar.isPresent())
      {
          throw new NotFoundException("No existe dicho dni");
      }

        return listar.get();
    }


    public void addUpdateEmpleados(EmpleadosModel empleadosModel){

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
