package com.example.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pessoa;
import com.example.demo.service.PessoaServiceInt;

@RestController
@RequestMapping("/pessoa")

public class PessoaController {

    @Autowired
    private PessoaServiceInt pessoaService;

    @PostMapping("/criar")
    public ResponseEntity<?> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaCriada = pessoaService.criarPessoa(pessoa);
        if (Objects.isNull(pessoaCriada)) {
            return ResponseEntity.badRequest().body("erro ao criar pessoa.");
        }
        return ResponseEntity.ok().body(pessoaCriada);
    }

    @PutMapping("/editar")
    public ResponseEntity<?> editarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa pessoaEditada = pessoaService.editarPessoa(pessoa);
        if (Objects.isNull(pessoaEditada)) {
            return ResponseEntity.badRequest().body("erro ao editar pessoa.");
        }
        return ResponseEntity.ok().body(pessoaEditada);

    }

    @GetMapping("/consultarPessoa/{id}")
    public ResponseEntity<?> consultarPessoa(@PathVariable Long id) {
        Optional<Pessoa> pessoaConsultada = pessoaService.consultarPessoa(id);
        {
            if (pessoaConsultada.isEmpty()) {
                return ResponseEntity.badRequest().body("erro ao consultar pessoa.");
            }
            return ResponseEntity.ok().body(pessoaConsultada);
        }
    }

    @GetMapping("/listarPessoas")
    public ResponseEntity<?> listarPessoas() {
        List<Pessoa> pessoasListada = pessoaService.listarPessoas();
        {
            if (pessoasListada.isEmpty()) {
                return ResponseEntity.badRequest().body("erro ao listar pessoas.");
            }
            return ResponseEntity.ok().body(pessoasListada);
        }

    }
    @DeleteMapping("/deletarPessoa/{id}")
    public ResponseEntity<?> deletarPessoa(@PathVariable Long id){
        if(!pessoaService.deletarPessoa(id)){
            return ResponseEntity.badRequest().body("erro ao deletar pessoa.");

        }
        return ResponseEntity.ok("pessoa deletado com sucesso!");

    }

}
