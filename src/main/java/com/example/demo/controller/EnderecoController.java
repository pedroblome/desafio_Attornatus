package com.example.demo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> criarEndereco(@RequestBody Endereco endereco) {
        Endereco enderecoCriado = enderecoServiceInt.criarEnderecoPessoa(endereco);
        if (Objects.isNull(enderecoCriado)) {
            return ResponseEntity.badRequest().body("erro ao criar endereco.");
        }
        return ResponseEntity.ok(enderecoCriado);
    }

    @GetMapping("/consultarEndePrin/{idPessoa}")
    public ResponseEntity<?> consultarEndePrin(@PathVariable Long idPessoa) {
        Endereco enderecoPrin = enderecoServiceInt.consultarEnderecoPrinPessoa(idPessoa);
        if (Objects.isNull(enderecoPrin )) {
            return ResponseEntity.badRequest().body("erro ao consultar endereco prin dessa pessoa.");
        }
        return ResponseEntity.ok(enderecoPrin);

    }

    @GetMapping("/listarEnderecos")
    public ResponseEntity<?> listarEnderecos() {
        List<Endereco> enderecos = enderecoServiceInt.listarEnderecos();
        if (Objects.isNull(enderecos)) {
            return ResponseEntity.badRequest().body("erro ao consultar endereco prin dessa pessoa.");
        }
        return ResponseEntity.ok(enderecos);

    }

    @GetMapping("/consultarEndePessoa/{idPessoa}")
    public ResponseEntity<?> consultarEndePessoa(@PathVariable Long idPessoa) {
        List<Endereco> enderecos = enderecoServiceInt.consultarEnderecosPessoa(idPessoa);
        System.out.println(enderecos);
        if (Objects.isNull(enderecos)) {
            return ResponseEntity.badRequest().body("erro ao consultar endereco prin dessa pessoa.");
        }
        return ResponseEntity.ok(enderecos);

    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarEnderecoPessoa(@RequestBody Endereco endereco) {
        Endereco enderecoEditado = enderecoServiceInt.editarEnderecoPessoa(endereco);
        if (Objects.isNull(enderecoEditado)) {
            return ResponseEntity.badRequest().body("erro ao editar endereco.");
        }
        return ResponseEntity.ok(enderecoEditado);
    }

    @DeleteMapping("/deletarEndereco/{id}")
    public ResponseEntity<?> deletarEndereco(@PathVariable Long id) {
         
        if (!enderecoServiceInt.deletarEndereco(id)) {
            return ResponseEntity.badRequest().body("erro ao deletar endereco.");
        }
        return ResponseEntity.ok("endereco deletado com sucesso!");
    }


}
