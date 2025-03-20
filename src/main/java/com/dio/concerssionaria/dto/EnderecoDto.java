package com.dio.concerssionaria.dto;

import com.dio.concerssionaria.model.Endereco;

import lombok.Data;

@Data
public class EnderecoDto {

    private String cep;
    private String uf;
    private String logradouro;
    private String localidade;
    private String bairro;
    private String numero;

    public Endereco dtoToEnd(){
        Endereco end = new Endereco();
        end.setCep(this.cep.replace("-", ""));
        end.setBairro(this.bairro);
        end.setLocalidade(this.localidade);
        end.setLogradouro(this.logradouro);
        end.setUf(this.uf);
        end.setNumero(this.numero);

        return end;
    }

}
