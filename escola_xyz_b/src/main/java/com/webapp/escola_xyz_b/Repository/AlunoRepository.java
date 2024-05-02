package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository; // Importa a interface CrudRepository fornecida pelo Spring Data JPA
import com.webapp.escola_xyz_b.Model.Aluno; // Importa a classe Aluno
import java.util.List;


public interface AlunoRepository extends CrudRepository<Aluno, Long> {
    // Interface para realizar operações CRUD (Create, Read, Update, Delete) no banco de dados para a entidade Aluno
    Aluno findByCpf(Long cpf);//Metodo para buscar um aluno por cpf
    boolean existsByCpf(String cpf);//Metodo para verificar se o cpf do aluno existe no banco de dados
}
