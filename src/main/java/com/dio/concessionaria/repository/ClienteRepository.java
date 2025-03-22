package com.dio.concessionaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.concessionaria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {

}
