package com.example.Empleados.repository;
import com.example.Empleados.model.Empleados;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmpleadosRepository extends MongoRepository<Empleados,String> {

    @Override
    void deleteById(String s);

    @Override
    List<Empleados> findAll();

    @Override
    <S extends Empleados> S save(S entity);

    @Override
    Optional<Empleados> findById(String s);
}
