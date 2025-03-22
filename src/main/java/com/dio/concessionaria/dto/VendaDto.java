package com.dio.concessionaria.dto;

import java.time.LocalDate;
import com.dio.concessionaria.model.Venda;
import lombok.Data;
@Data
public class VendaDto {

    private float valor;
    private LocalDate vdata;
    private FuncionarioDto funcionario;
    private ClienteDto cliente;
    private VeiculoDto veiculo;

    public Venda dtoToVenda(){
        Venda ve = new Venda(); 
        ve.setCliente(this.cliente.dtoToCliente());
        ve.setFuncionario(this.funcionario.funcionarioDtoToDto());
        ve.setValor(this.valor);
        ve.setVdata(this.vdata);
        ve.setVeiculo(this.veiculo.dtoToVeiculo());
        return ve;
    }

}

