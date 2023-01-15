package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "endereco_tb")
public class Endereco {

    public Endereco() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;

    @Column(columnDefinition = "boolean default false")
    private boolean enderecoPrin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pessoa_id")
    @JsonBackReference
    private Pessoa pessoa;



    public Endereco(Long id, String logradouro, String cep, Integer numero, String cidade, boolean enderecoPrin,
            Pessoa pessoa) {
        this.id = id;
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.enderecoPrin = enderecoPrin;
        this.pessoa = pessoa;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getLogradouro() {
        return logradouro;
    }


    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }


    public String getCep() {
        return cep;
    }


    public void setCep(String cep) {
        this.cep = cep;
    }


    public Integer getNumero() {
        return numero;
    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }


    public String getCidade() {
        return cidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public boolean getEnderecoPrin() {
        return enderecoPrin;
    }


    public void setEnderecoPrin(boolean enderecoPrin) {
        this.enderecoPrin = enderecoPrin;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }


    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "Endereco [id=" + id + ", logradouro=" + logradouro + ", cep=" + cep + ", numero=" + numero + ", cidade="
                + cidade + ", enderecoPrin=" + enderecoPrin + ", pessoa=" + pessoa + "]";
    }



}
