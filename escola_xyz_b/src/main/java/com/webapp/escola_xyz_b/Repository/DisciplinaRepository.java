package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository; // Importa a interface CrudRepository fornecida pelo Spring Data JPA
import com.webapp.escola_xyz_b.Model.Disciplina; // Importa a classe Disciplina
import java.util.List; // Importa a classe List do Java

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
    // Interface para realizar operações CRUD (Create, Read, Update, Delete) no banco de dados para a entidade Disciplina

    // Método para encontrar uma disciplina pelo nome
    Disciplina findByNome(String nome);

    // Método para verificar se uma disciplina com o nome fornecido existe
    boolean existsByNome(String nome);
}
