package com.empleados.openapi.api;

import com.empleados.openapi.model.Empleados;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-04T10:06:15.344848100+02:00[Europe/Madrid]")
@Controller
@RequestMapping("${openapi.empleados.base-path:/AnaCarolina12/MyApiCompany/1.0}")
public class EmpleadosApiController implements EmpleadosApi {

    private final EmpleadosApiDelegate delegate;

    public EmpleadosApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) EmpleadosApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new EmpleadosApiDelegate() {});
    }

    @Override
    public EmpleadosApiDelegate getDelegate() {
        return delegate;
    }

    @Override
    public List<Empleados> getAllEmpleados() {
        return null;
    }

    @Override
    public Empleados getEmpleado(String dni) {
        return null;
    }

    @Override
    public void addUpdateEmpleados(com.example.Empleados.models.Empleados empleadosModel) {

    }

    @Override
    public void deleteEmpelados(String dni) {

    }

}
