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
public class EnderecoServiceImp implements EnderecoServiceInt{

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired PessoasRepository pessoasRepository;


    private boolean validaPessoa(Endereco endereco){
        //valida se endereco tem o campo pessoa e se esse campo pessoa tem id e esse campo id representa alguem ja criado no banc
        if(endereco.getPessoa().getId() == null){
            return false;
        }
        Optional<Pessoa> pessoa = pessoasRepository.findById(endereco.getPessoa().getId());
        if(pessoa.isEmpty()){
            return false;
        }
        return true;
    }

    private boolean validaEndereco(Endereco endereco){
        if(Objects.isNull(endereco.getCep())){
            return false;
        }
        if(Objects.isNull(endereco.getCidade())){
            return false;
        }
        if(Objects.isNull(endereco.getLogradouro())){
            return false;
        }
        if(Objects.isNull(endereco.getNumero())){
            return false;
        }

        return true;
    }

    @Override
    public Endereco criarEnderecoPessoa(Endereco endereco) {
        if(validaEndereco(endereco) && validaPessoa(endereco)){
            Endereco enderecoCriado = enderecoRepository.save(endereco);
            return enderecoCriado;
        }
        return null;

    }

    @Override
    public Endereco editarEnderecoPessoa(Endereco endereco) {
        //id must be informed to edit an adress
        if(validaEndereco(endereco) && validaPessoa(endereco)){
            Endereco enderecoCriado = enderecoRepository.save(endereco);
            return enderecoCriado;
        }
        return null;
    }

    @Override
    public List<Endereco> consultarEnderecosPessoa(Integer idPessoa) {
                // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Endereco consultarEnderecoPrinPessoa(Integer idPessoa) {
        // TODO Auto-generated method stub
        return null;
    }

  


    
}
