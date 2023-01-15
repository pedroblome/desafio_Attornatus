package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Pessoa;

@Transactional
public interface PessoasRepository extends JpaRepository<Pessoa, Long>{
    
}
