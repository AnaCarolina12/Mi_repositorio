package com.empleados.openapi.api;

import com.empleados.openapi.model.Empleados;
import com.empleados.openapi.model.InlineResponse400;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link EmpleadosApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-05-04T10:06:15.344848100+02:00[Europe/Madrid]")
public interface EmpleadosApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /empleados/{dni}
     *
     * @param dni  (required)
     * @return OK (status code 200)
     * @see EmpleadosApi#empleadosDniDelete
     */
    default ResponseEntity<Void> empleadosDniDelete(String dni) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /empleados/{dni}
     * Obtain information about an employee from his or her unique dni
     *
     * @param dni  (required)
     * @return OK (status code 200)
     *         or Error de petición (status code 400)
     * @see EmpleadosApi#empleadosDniGet
     */
    default ResponseEntity<Void> empleadosDniGet(String dni) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /empleados
     * Returns a list of employees
     *
     * @return OK (status code 200)
     *         or Error de petición (status code 400)
     * @see EmpleadosApi#empleadosGet
     */
    default ResponseEntity<List<Empleados>> empleadosGet() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"apellidos\" : \"apellidos\", \"nombre\" : \"nombre\", \"dni\" : \"dni\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * POST /empleados
     * Post a new employee
     *
     * @param empleados  (required)
     * @return OK (status code 200)
     *         or Error de petición (status code 400)
     * @see EmpleadosApi#empleadosPost
     */
    default ResponseEntity<Void> empleadosPost(Empleados empleados) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
