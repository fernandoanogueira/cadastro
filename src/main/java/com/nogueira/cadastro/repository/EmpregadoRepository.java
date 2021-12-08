package com.nogueira.cadastro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nogueira.cadastro.model.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
	
	@Query("select e from Empregado e where e.id = :idEmpregado and e.empresa.id = :idEmpresa ")
	public List<Empregado> consultarEmpresaDoEmpregado(@Param("idEmpresa") Long idEmpresa, @Param("idEmpregado") Long idEmpregado);

}
