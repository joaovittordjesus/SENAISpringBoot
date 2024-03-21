package com.escola.escola_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escola.escola_crud.model.Professor;

// ProfessorRepository.java
public interface ProfessorRepository extends JpaRepository<Professor, String> {
}
