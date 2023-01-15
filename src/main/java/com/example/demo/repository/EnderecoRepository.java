package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{

    @Query("SELECT e FROM Endereco e WHERE e.pessoa.id = :pessoaId")
    List<Endereco> findByPessoaId(@Param("pessoaId") Long pessoaId);

    // @Query("UPDATE Endereco_TB SET enderecoPrin = false;")
    // void setFalsePrinAdress();
    @Modifying
@Transactional
@Query("UPDATE Endereco_TB SET enderecoPrin = false")
void setFalsePrinAdress();


    
}
