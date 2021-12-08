package com.nogueira.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nogueira.cadastro.dto.EmpregadoDTO;
import com.nogueira.cadastro.model.Empregado;
import com.nogueira.cadastro.repository.EmpregadoRepository;

@Service
public class EmpregadoService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	public EmpregadoDTO consultarEmpregadoPorId(Long id) {
		Empregado empregado = empregadoRepository.findById(id).orElse(null);
		if(empregado!=null)
			return mapper.map(empregado, EmpregadoDTO.class);		
		else
			return null;
	}

	public List<EmpregadoDTO> listarEmpregados() {
		List<Empregado> empregados = empregadoRepository.findAll();
		List<EmpregadoDTO> empregadosDTO = new ArrayList<>();
		empregados.stream().forEach(empresa -> empregadosDTO.add(mapper.map(empregados, EmpregadoDTO.class)));
		return empregadosDTO;
	}
	
	public boolean validarVinculoEmpresaEmpregado(Long idEmpresa, Long idEmpregado) {
		return !empregadoRepository.consultarEmpresaDoEmpregado(idEmpresa, idEmpregado).isEmpty();
	}
}
