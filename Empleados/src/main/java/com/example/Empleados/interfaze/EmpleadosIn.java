package com.example.Empleados.interfaze;

import com.example.Empleados.models.Empleados;

import java.util.List;

public interface EmpleadosIn {
    List<Empleados> getAllEmpleados();
    Empleados getEmpleados(String dni);
    void addUpdateEmpleados(Empleados empleadosModel);
    void deleteEmpleados(String dni);
}
