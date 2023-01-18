package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Pessoa;
import com.example.demo.repository.PessoasRepository;

@Service
public class PessoaServiceImp implements PessoaServiceInt {

    @Autowired
    private PessoasRepository pessoasRepository;

    private boolean validaCriarPessoa(Pessoa pessoa) {
        if (Objects.isNull(pessoa.getnome()) && Objects.isNull(pessoa.getDataNascimento())) {
            return false;
        }
        return true;
    }

    private boolean validaEditarPessoa(Pessoa pessoa) {

        Optional<Pessoa> pessaoEditada = pessoasRepository.findById(pessoa.getId());
        if (Objects.isNull(pessaoEditada)) {
            return false;
        }
        if (Objects.isNull(pessoa.getnome()) && Objects.isNull(pessoa.getDataNascimento())) {
            return false;
        }
        return true;
    }

    private boolean validaExistePessoa(Long id) {
        Optional<Pessoa> pessoa = pessoasRepository.findById(id);
        if (Objects.isNull(pessoa)) {
            System.out.println("pesosa n existe");
            return false;
        }
        System.out.println("pesosa  existe");

        return true;
    }

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        if (validaCriarPessoa(pessoa)) {
            Pessoa pessoaCriada = pessoasRepository.save(pessoa);
            return pessoaCriada;

        }
        return null;
    }

    @Override
    public Pessoa editarPessoa(Pessoa pessoa) {
        // to edit an person is necessary to inform the id, if no the jpa will create a
        // new person with this data
        if (validaEditarPessoa(pessoa)) {
            Pessoa pessoaEditada = pessoasRepository.save(pessoa);
            return pessoaEditada;
        }
        return null;
    }

    @Override
    public Optional<Pessoa> consultarPessoa(Long id) {
        Optional<Pessoa> pessoaConsultada = pessoasRepository.findById(id);
        return pessoaConsultada;
    }

    @Override
    public List<Pessoa> listarPessoas() {
        List<Pessoa> pessoasList = pessoasRepository.findAll();
        return pessoasList;
    }

    @Override
    public boolean deletarPessoa(Long id) {
        Optional<Pessoa> pessoaDeletar = pessoasRepository.findById(id);
        if (pessoaDeletar.isEmpty()) {
            return false;
        }
        pessoasRepository.deleteById(id);
        return true;

    }

}
