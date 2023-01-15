package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Endereco;


@Transactional
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

    
}
