package com.webapp.escola_xyz_b.Repository;

import com.webapp.escola_xyz_b.Model.Matricula; // Importa a classe Matricula
//import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository
import org.springframework.data.repository.CrudRepository;

public interface MatriculaRepository extends CrudRepository<Matricula, Long> {
    // Interface para realizar operações CRUD (Create, Read, Update, Delete) no banco de dados para a entidade Matricula

    // Método para verificar se a matrícula de um aluno existe em uma determinada disciplina
    boolean existsByAlunoAndDisciplina(Long alunoId, Long disciplinaId);//Implementar feedback para o usuario.
}
