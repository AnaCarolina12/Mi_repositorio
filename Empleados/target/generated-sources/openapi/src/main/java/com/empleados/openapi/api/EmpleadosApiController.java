package com.empleados.openapi.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-04-08T11:48:55.960339400+02:00[Europe/Madrid]")
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

}
