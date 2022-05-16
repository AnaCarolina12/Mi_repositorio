package com.example.Empleados.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.example.Empleados.dto.EmpleadosDTO;
import com.example.Empleados.exceptions.BadRequestException;
import com.example.Empleados.exceptions.NoContentException;
import com.example.Empleados.interfaz.EmpleadosInterface;
import com.example.Empleados.mapper.EmpleadosMapper;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class EmpleadosServiceImp implements EmpleadosInterface {

  @Autowired
  private EmpleadosRepository empleadosRepository;

  @Autowired
  private EmpleadosMapper empleadosMapper = Mappers.getMapper(EmpleadosMapper.class);

  public List<EmpleadosDTO> getAllEmpleados() {

    List<Empleados> empleadosgetlista = empleadosRepository.findAll();
    List<EmpleadosDTO> empleadosDTOlistar = empleadosMapper.toempleados(empleadosgetlista);

    if (CollectionUtils.isEmpty(empleadosDTOlistar)) {
      throw new NoSuchElementException("No existe los empleados");
    }

    return empleadosDTOlistar;
  }

  @Override
  public EmpleadosDTO getEmpleados(String dni) {

    Optional<Empleados> e = empleadosRepository.findById(dni);
    Optional<EmpleadosDTO> listar = Optional.ofNullable(empleadosMapper.empleadosDTOtoEmpleados(e.get()));

    if (!listar.isPresent()) {

      throw new NoSuchElementException("Errror");

    }
    return listar.get();

  }

  @Override
  public EmpleadosDTO addUpdateEmpleados(EmpleadosDTO empleadosDTO) {

    boolean emptyName = StringUtils.isEmpty(empleadosDTO.getNombreEmpleado());
    boolean emptySurname = StringUtils.isEmpty(empleadosDTO.getApellidos());
    boolean emptyDni = StringUtils.isEmpty(empleadosDTO.getDni());
    boolean expReg = empleadosDTO.getDni().matches("[0-9]{8}[A-Z]");

    if (emptyName || emptySurname) {
      throw new NoContentException("El nombre o apellidos esta vacio");
    } else if (emptyDni) {

      throw new NoContentException("El dni del empleado esta vacio");

    } else if (!expReg) {

      throw new BadRequestException("El dni no cumple con el patron");

    }

    Empleados emp = empleadosMapper.empleadostoEmpleadosDTO(empleadosDTO);
    Empleados saveempleado = empleadosRepository.save(emp);
    EmpleadosDTO saveEmpleadosDTO = empleadosMapper.empleadosDTOtoEmpleados(saveempleado);

    return saveEmpleadosDTO;

  }

  @Override
  public void deleteEmpleados(String dni) {
    getEmpleados(dni);
    empleadosRepository.deleteById(dni);

  }

}
