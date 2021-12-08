package com.nogueira.cadastro.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.nogueira.cadastro.dto.CartaoDTO;
import com.nogueira.cadastro.service.CartaoService;
import com.nogueira.cadastro.service.EmpregadoService;
import com.nogueira.cadastro.service.EmpresaService;

import io.restassured.http.ContentType;

@WebMvcTest
public class CartaoControllerTest {
	
	@Autowired
	private CartaoController cartaoController;
	
	@MockBean
	private CartaoService cartaoService;
	
	@MockBean
	private EmpregadoService empregadoService;
	
	@MockBean
	private EmpresaService empresaService;	
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.cartaoController);
	}
	
	@Test
	public void deveRetornarSucesso_QuandoBuscarCartaoValido() {
		
		when(this.cartaoService.consultarCartaoPorId(1L))
		.thenReturn(new CartaoDTO(1L, "Cartão de Teste", "CA"));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/cartao/{id}", 1L)
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void deveRetornarNaoEncontrado_QuandoBuscarBuscarCartaoInvalido() {
		
		when(this.cartaoService.consultarCartaoPorId(5L))
		.thenReturn(null);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/cartao/{id}", 5L)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
		
		
	}

	@Test
	public void deveRetornarBadRequest_QuandoBuscarCartaoComParametroNegativo() {
	
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/cartao/{id}", -1L)
		.then()
			.statusCode(HttpStatus.BAD_REQUEST.value());
		
		verify(this.cartaoService, never()).consultarCartaoPorId(-1L);
	}
	
}