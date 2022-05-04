/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.1.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.empleados.openapi.api;

import com.empleados.openapi.model.Empleados;
import com.empleados.openapi.model.InlineResponse400;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-04T10:06:15.344848100+02:00[Europe/Madrid]")
@Validated
@Api(value = "empleados", description = "the empleados API")
public interface EmpleadosApi {

    default EmpleadosApiDelegate getDelegate() {
        return new EmpleadosApiDelegate() {};
    }

    /**
     * DELETE /empleados/{dni}
     *
     * @param dni  (required)
     * @return OK (status code 200)
     */
    @ApiOperation(value = "", nickname = "empleadosDniDelete", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK") })
    @DeleteMapping(
        value = "/empleados/{dni}"
    )
    default ResponseEntity<Void> empleadosDniDelete(@ApiParam(value = "",required=true) @PathVariable("dni") String dni) {
        return getDelegate().empleadosDniDelete(dni);
    }


    /**
     * GET /empleados/{dni}
     * Obtain information about an employee from his or her unique dni
     *
     * @param dni  (required)
     * @return OK (status code 200)
     *         or Error de petición (status code 400)
     */
    @ApiOperation(value = "", nickname = "empleadosDniGet", notes = "Obtain information about an employee from his or her unique dni", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Error de petición", response = InlineResponse400.class) })
    @GetMapping(
        value = "/empleados/{dni}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> empleadosDniGet(@ApiParam(value = "",required=true) @PathVariable("dni") String dni) {
        return getDelegate().empleadosDniGet(dni);
    }


    /**
     * GET /empleados
     * Returns a list of employees
     *
     * @return OK (status code 200)
     *         or Error de petición (status code 400)
     */
    @ApiOperation(value = "", nickname = "empleadosGet", notes = "Returns a list of employees", response = Empleados.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Empleados.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "Error de petición", response = InlineResponse400.class) })
    @GetMapping(
        value = "/empleados",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Empleados>> empleadosGet() {
        return getDelegate().empleadosGet();
    }


    /**
     * POST /empleados
     * Post a new employee
     *
     * @param empleados  (required)
     * @return OK (status code 200)
     *         or Error de petición (status code 400)
     */
    @ApiOperation(value = "", nickname = "empleadosPost", notes = "Post a new employee", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 400, message = "Error de petición", response = InlineResponse400.class) })
    @PostMapping(
        value = "/empleados",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> empleadosPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Empleados empleados) {
        return getDelegate().empleadosPost(empleados);
    }


    List<Empleados> getAllEmpleados();

    Empleados getEmpleado(String dni);

    void addUpdateEmpleados(com.example.Empleados.models.Empleados empleadosModel);

    void deleteEmpelados(@PathVariable String dni);
}
