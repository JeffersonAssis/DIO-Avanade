package com.dio.concessionaria.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.concessionaria.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String>{
} 
