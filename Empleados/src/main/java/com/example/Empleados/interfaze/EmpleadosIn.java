package com.example.Empleados.interfaze;

import com.example.Empleados.model.Empleados;

import java.util.List;

public interface EmpleadosIn {
    List<Empleados> getAllEmpleados();
    Empleados getEmpleados(String dni);
    Empleados addUpdateEmpleados(Empleados empleados);
    void deleteEmpleados(String dni);
}
