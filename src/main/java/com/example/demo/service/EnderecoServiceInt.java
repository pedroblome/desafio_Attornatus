package com.example.demo.service;



import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Endereco;

public interface EnderecoServiceInt {

    public Endereco criarEnderecoPessoa(Endereco endereco);
    public Endereco editarEnderecoPessoa(Endereco endereco);
    public List<Endereco> consultarEnderecosPessoa(Long idPessoa);
    public List<Endereco> listarEnderecos();
    public Endereco consultarEnderecoPrinPessoa(Long idPessoa);
    
}
