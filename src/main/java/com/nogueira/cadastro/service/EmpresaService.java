package com.nogueira.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.nogueira.cadastro.dto.EmpresaDTO;
import com.nogueira.cadastro.model.Empresa;
import com.nogueira.cadastro.repository.EmpresaRepository;

@Service
public class EmpresaService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public EmpresaDTO consultarEmpresaPorId(Long id) {
		Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa não encontrada"));
		return mapper.map(empresa, EmpresaDTO.class);
	}

	public List<EmpresaDTO> listarEmpresas() {
		List<Empresa> empresas = empresaRepository.findAll();
		List<EmpresaDTO> empresasDTO = new ArrayList<>();
		empresas.stream().forEach(empresa -> empresasDTO.add(mapper.map(empresa, EmpresaDTO.class)));
		return empresasDTO;
	}


}