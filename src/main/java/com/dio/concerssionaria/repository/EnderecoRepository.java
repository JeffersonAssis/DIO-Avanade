package com.dio.concerssionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.concerssionaria.model.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, String> {   
}