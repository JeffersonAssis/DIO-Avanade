package com.dio.concessionaria.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.dio.concessionaria.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {
     

    @Query("SELECT v FROM Venda v WHERE v.funcionario = :cpf")
    List<Venda> findByFuncionarioAll(String cpf);

    boolean existsByVeiculoPlaca(String placa);

}
