package com.example.Empleados.repository;

import com.example.Empleados.models.EmpleadosModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface EmpleadosRepository extends MongoRepository<EmpleadosModel, UUID> {
    boolean existsByDni(String dni);
    EmpleadosModel findByDni(String dni);
    EmpleadosModel deleteByDni(String dni);

}
