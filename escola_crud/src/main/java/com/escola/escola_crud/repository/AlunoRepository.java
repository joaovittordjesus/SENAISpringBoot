package com.escola.escola_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.escola_crud.model.Aluno;

// AlunoRepository.java
public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
