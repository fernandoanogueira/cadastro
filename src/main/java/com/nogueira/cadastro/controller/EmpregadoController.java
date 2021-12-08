package com.nogueira.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nogueira.cadastro.dto.EmpregadoDTO;
import com.nogueira.cadastro.service.EmpregadoService;

@RestController
public class EmpregadoController {
	
	@Autowired
	private EmpregadoService service;
	
	@GetMapping(value = "/empregado/{id}")
	public ResponseEntity<EmpregadoDTO> consultarEmpregadoPorId(@PathVariable(required=true) Long id){
		EmpregadoDTO empregadoDTO =  service.consultarEmpregadoPorId(id);
		if(empregadoDTO!=null)
			return ResponseEntity.ok(empregadoDTO);
		else
			return ResponseEntity.notFound().build();
	}
	
	@GetMapping(value = "/empregado/")
	public List<EmpregadoDTO> listarEmpregados(){
		return service.listarEmpregados();
	}
	
	@GetMapping(value = "/empregado/{idEmpresa}/{idEmpregado}/vinculo")
	public boolean validarVinculoEmpresaEmpregado(@PathVariable(required=true) Long idEmpresa, 
			@PathVariable(required=true) Long idEmpregado) {
		return service.validarVinculoEmpresaEmpregado(idEmpresa, idEmpregado);
	}

}
