package com.example.demo.service;

import java.util.List;
import java.util.Optional;



import com.example.demo.entity.Pessoa;


public interface PessoaServiceInt {

    public Pessoa criarPessoa(Pessoa pessoa);
    public Pessoa editarPessoa(Pessoa pessoa);
    public Optional<Pessoa> consultarPessoa(Long id);
    public List<Pessoa> listarPessoas();
    public boolean deletarPessoa(Long id);

}
