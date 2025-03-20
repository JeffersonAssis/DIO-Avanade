package com.dio.concerssionaria.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.concerssionaria.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

    Optional<Veiculo> findByPlaca(String placa);
    boolean existsByPlaca(String placa);

} 
