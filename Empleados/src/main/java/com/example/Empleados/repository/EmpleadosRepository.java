package com.example.Empleados.repository;
import com.example.Empleados.model.Empleados;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmpleadosRepository extends MongoRepository<Empleados,String> {


    void deleteById(String s);

    List<Empleados> findAll();

    Empleados save(Empleados empleados);


    Optional<Empleados> findById(String s);
}
