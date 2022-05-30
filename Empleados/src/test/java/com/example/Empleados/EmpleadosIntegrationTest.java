package com.example.Empleados;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.Empleados.model.Empleados;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;

class EmpleadosIntegrationTest {

  @Test
  void getAllEmpleados() {

    // quiero verificar que el cuerpo del objeto JSON no esté vacio.

    given().contentType(ContentType.JSON).when().get("/empleados").then()
        .body("empty", equalTo(false))
        .statusCode(200);

    //.... .log().body();

  }

  @Test
  void getEmpleado() {

    ValidatableResponse response = given().contentType(ContentType.JSON).
        pathParameters("dni", "11111112T").when().get("/empleados/{dni}")
        .then().statusCode(200);

    Empleados e = response.extract().as(Empleados.class);

    assertEquals("11111112T", e.getDni());
    assertEquals("AnaContainer", e.getNombre());
    assertEquals("Sangucho", e.getApellidos());
  }

  @Test
  void addUpdateEmpleados() {
    Empleados empleados1 = getEmpleadosModel("12345678M", "Ana", "Cruz");
    ValidatableResponse response = given().contentType(ContentType.JSON)
        .body(empleados1).when().post("/empleados").then().statusCode(200);

    Empleados e = response.extract().as(Empleados.class);

    assertEquals("12345678M", e.getDni());
    assertEquals("Ana", e.getNombre());
    assertEquals("Cruz", e.getApellidos());
  }

  @Test
  void deleteEmpleados() {

    given().contentType(ContentType.JSON).pathParameters("dni", "12345678M").when().delete("/empleados/{dni}")
        .then().statusCode(200);

  }

  private Empleados getEmpleadosModel(String dni, String nombre, String apellidos) {
    Empleados empleados = new Empleados();

    empleados.setDni(dni);
    empleados.setNombre(nombre);
    empleados.setApellidos(apellidos);

    return empleados;
  }

}