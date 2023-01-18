package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Endereco;
import com.example.demo.entity.Pessoa;
import com.example.demo.repository.EnderecoRepository;
import com.example.demo.repository.PessoasRepository;

@Service
public class EnderecoServiceImp implements EnderecoServiceInt {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    PessoasRepository pessoasRepository;

    private void valdidaEnderecoPrin(Endereco endereco) {

        List<Endereco> enderecos = enderecoRepository.findByPessoaId(endereco.getPessoa().getId());
        if (endereco.getEnderecoPrin() == true) {
            enderecoRepository.setFalsePrinAdress();
        }
        if (enderecos.isEmpty()) {
            endereco.setEnderecoPrin(true);
        }

    }

    private boolean validaPessoa(Endereco endereco) {
        // valida se endereco tem o campo pessoa e se esse campo pessoa tem id e esse
        // campo id representa alguem ja criado no banc
        if (endereco.getPessoa().getId() == null) {
            return false;
        }
        Optional<Pessoa> pessoa = pessoasRepository.findById(endereco.getPessoa().getId());
        if (pessoa.isEmpty()) {
            return false;
        }
        return true;
    }

    private boolean validaEndereco(Endereco endereco) {
        if (Objects.isNull(endereco.getCep())) {
            return false;
        }
        if (Objects.isNull(endereco.getCidade())) {
            return false;
        }
        if (Objects.isNull(endereco.getLogradouro())) {
            return false;
        }
        if (Objects.isNull(endereco.getNumero())) {
            return false;
        }

        return true;
    }

    @Override
    public Endereco criarEnderecoPessoa(Endereco endereco) {
        valdidaEnderecoPrin(endereco);
        if (validaEndereco(endereco) && validaPessoa(endereco)) {
            Endereco enderecoCriado = enderecoRepository.save(endereco);
            return enderecoCriado;
        }
        return null;

    }

    @Override
    public Endereco editarEnderecoPessoa(Endereco endereco) {
        // id must be informed to edit an adress
        if (validaEndereco(endereco) && validaPessoa(endereco)) {
            Endereco enderecoCriado = enderecoRepository.save(endereco);
            return enderecoCriado;
        }
        return null;
    }

    @Override
    public List<Endereco> consultarEnderecosPessoa(Long idPessoa) {
        List<Endereco> enderecos = enderecoRepository.findByPessoaId(idPessoa);
        if (Objects.isNull(enderecos)) {
            return null;
        }
        return enderecos;
    }

    @Override
    public Endereco consultarEnderecoPrinPessoa(Long idPessoa) {
        Endereco enderecoPrin = enderecoRepository.findByPessoaIdPrinEndere(idPessoa);
        if (Objects.isNull(enderecoPrin)) {
            return null;
        }
        return enderecoPrin;

    }

    @Override
    public List<Endereco> listarEnderecos() {

        return enderecoRepository.showAllAdress();
        // return enderecoRepository.showAllAdress();
    }

    @Override
    public Boolean deletarEndereco(Long idEndereco) {
        Optional<Endereco> enderecoDeletar = enderecoRepository.findById(idEndereco);

        if (enderecoDeletar.isEmpty()) {
            return false;
        }
        enderecoRepository.deleteById(idEndereco);
        return true;
    }

}
