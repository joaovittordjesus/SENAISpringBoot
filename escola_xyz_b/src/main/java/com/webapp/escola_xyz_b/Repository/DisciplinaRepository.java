package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.Disciplina;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
    // Podemos adicionar métodos adicionais aqui, se necessário
}
