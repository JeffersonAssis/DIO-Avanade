package com.dio.concessionaria.model;

import java.time.LocalDate;
import com.dio.concessionaria.dto.VendaDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private float valor;
    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate vdata;
    @ManyToOne
    @JoinColumn(name = "cpf_fun", referencedColumnName = "cpf")
    private Funcionario funcionario;
    @ManyToOne
    @JoinColumn(name = "cpf_cli", referencedColumnName = "cpf")
    private Cliente cliente;
    @OneToOne
    private Veiculo veiculo;

    public VendaDto vendaToDto(){
        VendaDto veDto= new VendaDto(); 
        veDto.setCliente(this.cliente.clienteToDto());
        veDto.setFuncionario(this.funcionario.funcionarioDtoToDto());
        veDto.setValor(this.valor);
        veDto.setVdata(this.vdata);
        veDto.setVeiculo(this.veiculo.veiculoToDto());
        return veDto;
    }
}
