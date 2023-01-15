package com.example.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Endereco;
import com.example.demo.service.EnderecoServiceInt;


@RestController
@RequestMapping("/endereco")

public class EnderecoController {

    @Autowired
    private EnderecoServiceInt enderecoServiceInt;

    @PostMapping("/criar")
    public ResponseEntity<?> criarEndereco(@RequestBody Endereco endereco){
        Endereco enderecoCriado = enderecoServiceInt.criarEnderecoPessoa(endereco);
        if(Objects.isNull(enderecoCriado)){
            return ResponseEntity.badRequest().body("erro ao criar endereco");
        }
        return ResponseEntity.ok(enderecoCriado);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarEnderecoPessoa(@RequestBody Endereco endereco){
        Endereco enderecoEditado = enderecoServiceInt.editarEnderecoPessoa(endereco);
        if(Objects.isNull(enderecoEditado)){
            return ResponseEntity.badRequest().body("erro ao editar endereco");
        }
        return ResponseEntity.ok(enderecoEditado);
    }


    
}
