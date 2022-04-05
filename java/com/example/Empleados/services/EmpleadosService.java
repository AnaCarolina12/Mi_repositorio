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
@RequiredArgsConstructor
public class EmpleadosService {

    private final EmpleadosRepository empleadosRepository;

    public  List<EmpleadosModel> getAllEmpleados(){

        List<EmpleadosModel> lista=empleadosRepository.findAll();

       if(CollectionUtils.isEmpty(lista))
      {
        throw new NotFoundException("No hay ningún empleado");
      }

            return  lista;
    }


    public EmpleadosModel getEmpleados(String dni){

        boolean lista= empleadosRepository.existsByDni(dni);
        EmpleadosModel listar=empleadosRepository.findByDni(dni);

      if(!lista)
      {
          throw new NotFoundException("No existe dicho dni");
      }

        return listar;
    }


    public void addEmpleados(EmpleadosModel empleadosModel){

        boolean emptyName = StringUtils.isBlank(empleadosModel.getNombre());
        boolean emptySurname = StringUtils.isBlank(empleadosModel.getApellidos());

        boolean emptyDni= StringUtils.isBlank(empleadosModel.getDni());
        boolean dniexist = empleadosRepository.existsByDni(empleadosModel.getDni());

        boolean expReg = empleadosModel.getDni().matches("[0-9]{8}[A-Z]");
        if(emptyName || emptySurname)
        {
            throw new NoContentException("Un dato del empleado esta vacio");
        }

       else if(emptyDni)
        {
            throw new NoContentException("El campo dni está vacio");
        }

        else if(dniexist)
        {
            throw new BadRequestException("Este dni ya existe");
        }
        else if(!expReg)
        {
            throw new BadRequestException("El dni no cumple con el patron");
        }

        empleadosRepository.save(empleadosModel);

    }


    public void updateEmpleado(String dni, EmpleadosModel empleadosModel) {

        boolean emptyName = StringUtils.isBlank(empleadosModel.getNombre());
        boolean emptySurname = StringUtils.isBlank(empleadosModel.getApellidos());

        boolean emptyDni= StringUtils.isBlank(empleadosModel.getDni());
        boolean dniexist = empleadosRepository.existsByDni(dni);

        boolean expReg = empleadosModel.getDni().matches("[0-9]{8}[A-Z]");

        if(emptyName || emptySurname)

        {
            throw new NoContentException("Un dato del empleado está vacio ");

        }
        else if(emptyDni)
        {
            throw new NoContentException("El campo dni está vacio");
        }
        else if(dniexist)
        {
            throw new BadRequestException("Este dni ya existe");
        }
        else if(!expReg)
        {
            throw new BadRequestException("El dni no cumple con el patron");
        }

        empleadosRepository.save(empleadosModel);
    }


    public void deleteEmpleados(String dni){

        boolean existDni=empleadosRepository.existsByDni(dni);
        if (!existDni)
        {
            throw new NotFoundException("No existe dicho id ");

        }

            empleadosRepository.deleteByDni(dni);
    }

}
