package com.example.demo.service;



import java.util.List;

import com.example.demo.entity.Endereco;

public interface EnderecoServiceInt {

    public Endereco criarEnderecoPessoa(Endereco endereco);
    public Endereco editarEnderecoPessoa(Endereco endereco);
    public List<Endereco> consultarEnderecosPessoa(Integer idPessoa);
    public Endereco consultarEnderecoPrinPessoa(Integer idPessoa);
    
}
