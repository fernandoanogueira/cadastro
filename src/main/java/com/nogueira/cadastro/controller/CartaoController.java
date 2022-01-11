package com.nogueira.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nogueira.cadastro.config.FilterBeanService;
import com.nogueira.cadastro.dto.CartaoDTO;
import com.nogueira.cadastro.service.CartaoService;

@RestController
public class CartaoController {

	@Autowired
	private CartaoService service;

	@GetMapping(value = "/cartao/{id}")
	public ResponseEntity<CartaoDTO> consultarCartaoPorId(@PathVariable(required = true) Long id) {

		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}

		CartaoDTO cartao = service.consultarCartaoPorId(id);

		if (cartao != null)
			return ResponseEntity.ok(cartao);
		else
			return ResponseEntity.notFound().build();
	}

	@GetMapping("/cartaofiltro/{id}/{filtros}")
	public ResponseEntity<CartaoDTO> consultarCartaoPorIdFiltro(@PathVariable(required = true) Long id,
			@PathVariable(required = true) String filtros) {

		if (id < 0) {
			return ResponseEntity.badRequest().build();
		}

		CartaoDTO cartaoDto = service.consultarCartaoPorId(id);
		
		if (cartaoDto != null) {

			String[] campos = filtros.split(",");
			
			CartaoDTO cartaoFiltro = (CartaoDTO) FilterBeanService.mapearRetornoConformeParametros(campos, "cartaoFilter", cartaoDto);

			return ResponseEntity.ok(cartaoFiltro);
		} else
			return ResponseEntity.notFound().build();
	}

	@GetMapping(value = "/cartao/")
	public List<CartaoDTO> listarCartoes() {
		return service.listarCartoes();
	}

	@PostMapping(value = "/cartao/")
	public ResponseEntity<CartaoDTO> insereCartao(@RequestBody CartaoDTO cartaoDTO) {
		return ResponseEntity.ok(service.insereCartao(cartaoDTO));
	}

}
