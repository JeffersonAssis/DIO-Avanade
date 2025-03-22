package com.dio.concessionaria.dto;

import com.dio.concessionaria.model.Endereco;

import lombok.Data;

@Data
public class EnderecoDto {

    private String cep;
    private String uf;
    private String logradouro;
    private String localidade;
    private String bairro;

    public Endereco dtoToEnd(){
        
        Endereco end = new Endereco();
        String cepFormatado = (this.cep != null) ? this.cep.replace("-", "") : "";
        end.setCep(cepFormatado);
        end.setBairro(this.bairro);
        end.setLocalidade(this.localidade);
        end.setLogradouro(this.logradouro);
        end.setUf(this.uf);
    
        return end;
    }

}
