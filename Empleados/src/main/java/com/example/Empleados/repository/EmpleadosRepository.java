package com.example.Empleados.repository;
import com.example.Empleados.model.Empleados;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmpleadosRepository extends MongoRepository<Empleados,String> {

}
