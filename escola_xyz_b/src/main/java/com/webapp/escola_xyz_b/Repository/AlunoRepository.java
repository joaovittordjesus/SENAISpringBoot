package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    // Podemos adicionar métodos adicionais aqui, se necessário
}
