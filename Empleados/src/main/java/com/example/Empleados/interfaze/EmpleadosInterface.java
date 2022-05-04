package com.example.Empleados.interfaze;

import com.example.Empleados.model.Empleados;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface EmpleadosInterface {
    List<Empleados> getAllEmpleados();
    Empleados getEmpleados(String dni);
    Empleados addUpdateEmpleados(Empleados empleados);
    void deleteEmpleados(String dni);

}
