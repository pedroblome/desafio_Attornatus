package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

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


    @Query("SELECT e, p FROM Endereco e JOIN e.pessoa p")
    List<Endereco> showAllAdress();


    @Query("SELECT e FROM Endereco e WHERE e.pessoa.id = :pessoaId and e.enderecoPrin = true")
    Endereco findByPessoaIdPrinEndere(@Param("pessoaId") Long pessoaId);

    
    @Modifying
    @Transactional
    @Query("UPDATE Endereco SET enderecoPrin = false")
    void setFalsePrinAdress();



    
}
