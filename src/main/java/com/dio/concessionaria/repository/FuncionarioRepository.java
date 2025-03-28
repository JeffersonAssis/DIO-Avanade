package com.dio.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.concessionaria.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, String> {

}
