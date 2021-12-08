package com.nogueira.cadastro.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nogueira.cadastro.dto.CartaoDTO;
import com.nogueira.cadastro.model.Cartao;
import com.nogueira.cadastro.repository.CartaoRepository;

@Service
public class CartaoService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CartaoRepository cartaoRepository;
	
	public CartaoDTO consultarCartaoPorId(Long id) {
		Cartao cartao= cartaoRepository.findById(id).orElse(null);
		if(cartao!=null)
			return mapper.map(cartao, CartaoDTO.class);
		else
			return null;
	}

	public List<CartaoDTO> listarCartoes() {
		List<Cartao> pedidos = cartaoRepository.findAll();
		List<CartaoDTO> cartoesDTO = new ArrayList<>();
		pedidos.stream().forEach(cartao -> cartoesDTO.add(mapper.map(cartao, CartaoDTO.class)));
		return cartoesDTO;
	}

	public CartaoDTO insereCartao(CartaoDTO cartaoDTO) {
		Cartao cartao = mapper.map(cartaoDTO, Cartao.class);
		cartao = cartaoRepository.save(cartao);
		return mapper.map(cartao, CartaoDTO.class);
	}
}
