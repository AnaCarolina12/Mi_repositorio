package com.example.Empleados.service;

import java.util.List;
import java.util.Optional;

import com.example.Empleados.dto.EmpleadosDTO;
import com.example.Empleados.exceptions.BadRequestException;
import com.example.Empleados.exceptions.NoContentException;
import com.example.Empleados.exceptions.NotFoundException;
import com.example.Empleados.interfaze.EmpleadosInterface;
import com.example.Empleados.mapper.EmpleadosMapper;
import com.example.Empleados.model.Empleados;
import com.example.Empleados.repository.EmpleadosRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service

public class EmpleadosServiceImp implements EmpleadosInterface {

  @Autowired
  private EmpleadosRepository empleadosRepository;

  @Autowired
  private EmpleadosMapper empleadosMapper;

  public List<EmpleadosDTO> getAllEmpleados() {

    List<EmpleadosDTO> empleadosgetlista = empleadosMapper.toempleados(empleadosRepository.findAll()
    );
    if (CollectionUtils.isEmpty(empleadosgetlista)) {
      throw new NotFoundException("No existe los empleados");
    }

    return empleadosgetlista;
  }

  @Override
  public EmpleadosDTO getEmpleados(String dni) {

    Optional<Empleados> e = empleadosRepository.findById(dni);
    Optional<EmpleadosDTO> listar = Optional.ofNullable(empleadosMapper.empleadosDTOtoEmpleados(e.get()));

    if (!listar.isPresent()) {
      throw new NotFoundException("No existe dicho dni");
    } else {
      return listar.get();
    }
  }

  @Override
  public EmpleadosDTO addUpdateEmpleados(EmpleadosDTO empleadosDTO) {

    boolean emptyName = StringUtils.isBlank(empleadosDTO.getNombreEmpleado());
    boolean emptySurname = StringUtils.isBlank(empleadosDTO.getApellidos());

    boolean emptyDni = StringUtils.isBlank(empleadosDTO.getDni());
    boolean expReg = empleadosDTO.getDni().matches("[0-9]{8}[A-Z]");

    if (emptyName || emptySurname) {

      throw new NoContentException("Un dato del empleado esta vacio");

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
