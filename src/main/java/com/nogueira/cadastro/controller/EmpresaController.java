package com.nogueira.cadastro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nogueira.cadastro.dto.EmpresaDTO;
import com.nogueira.cadastro.service.EmpresaService;

@RestController
public class EmpresaController {
	
	@Autowired
	private EmpresaService service;
	
	@GetMapping(value = "/empresa/{id}")
	public EmpresaDTO consultarEmpresasPorId(@PathVariable(required=true) Long id){
		return service.consultarEmpresaPorId(id);
	}
	
	@GetMapping(value = "/empresa/")
	public List<EmpresaDTO> listarEmpresas(){
		return service.listarEmpresas();
	}
	
}
