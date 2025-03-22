package com.dio.concessionaria.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dio.concessionaria.dto.VendaDto;
import com.dio.concessionaria.dto.VendaDtoInsert;
import com.dio.concessionaria.model.Venda;
import com.dio.concessionaria.repository.VendaRepository;

@Service
public class VendaService {

  private VendaRepository vendaRepository;
  private ClienteService clienteService;
  private FuncionarioService funcionarioService;
  private VeiculoService veiculoService;

  @Autowired
  public VendaService(VendaRepository vendaRepository, ClienteService clienteService,
                       FuncionarioService funcionarioService, VeiculoService veiculoService) {
    this.vendaRepository = vendaRepository;
    this.clienteService = clienteService;
    this.funcionarioService = funcionarioService;
    this.veiculoService = veiculoService;
  }

  public VendaDto update(Long id, VendaDtoInsert vDto) {
    if(vendaRepository.existsById(id)) {
      return vendaRepository.save(setVenda(vDto).dtoToVenda()).vendaToDto();
    } else {
      throw new IllegalArgumentException("Venda não encontrada");
    }
  }

  public List<VendaDto> findAll() {
    return vendaRepository.findAll().stream().map(Venda::vendaToDto).collect(Collectors.toList());
  }

  public void delete(Long id) {
    if(vendaRepository.existsById(id)) {
      vendaRepository.deleteById(id);
    } else {
      throw new IllegalArgumentException("Venda não encontrada");
    }
  }

  public List<VendaDto> findByFuncionario(String cpf) {
      var venda = vendaRepository.findByFuncionarioAll(cpf).stream()
                                                              .map(Venda::vendaToDto)
                                                              .collect(Collectors.toList());
    if(venda.size() > 0)
           return venda;   

     throw new IllegalArgumentException("Nenhuma venda encontrada para este funcionário");
    
  }

  public VendaDto save(VendaDtoInsert vDto) {
    if(vendaRepository.existsByVeiculoPlaca(vDto.getPlacaVeiculo())) {
      throw new IllegalArgumentException("Veículo já vendido");
    }
    return vendaRepository.save(setVenda(vDto).dtoToVenda()).vendaToDto();
  }

  public VendaDto setVenda(VendaDtoInsert vDto) {
    VendaDto v = new VendaDto();
    var veiculo = veiculoService.findByPlaca(vDto.getPlacaVeiculo());
    var funcionario = funcionarioService.findByFuncionario(vDto.getIdFuncionario());
    var client = clienteService.findByCliente(vDto.getIdCliente());

    v.setCliente(client);
    v.setFuncionario(funcionario);
    v.setVeiculo(veiculo);
    v.setVdata(vDto.getVdata());
    v.setValor(vDto.getValor());

    return v;
  }
}
