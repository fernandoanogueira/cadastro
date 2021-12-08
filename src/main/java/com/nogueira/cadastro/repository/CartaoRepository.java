package com.nogueira.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nogueira.cadastro.model.Cartao;

@Repository
public interface CartaoRepository extends JpaRepository<Cartao, Long> {

}
