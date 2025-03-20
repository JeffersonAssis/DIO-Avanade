package com.dio.concerssionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.concerssionaria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
