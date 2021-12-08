package com.nogueira.cadastro.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.nogueira.cadastro.dto.EmpregadoDTO;
import com.nogueira.cadastro.service.EmpregadoService;

import io.restassured.http.ContentType;

@WebMvcTest
public class EmpregadoControllerTest {
	
	@Autowired
	private EmpregadoController empregadoController;
	
	@MockBean
	private EmpregadoService empregadoService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.empregadoController);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarEmpregado() {
		
		when(this.empregadoService.consultarEmpregadoPorId(1L))
		.thenReturn(new EmpregadoDTO(1L, "Nome", "123.456.789-00", null));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/empregado/{id}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
	}

}
