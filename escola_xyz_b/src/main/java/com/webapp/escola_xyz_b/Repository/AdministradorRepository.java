package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository; // Importa a interface CrudRepository fornecida pelo Spring Data JPA
import com.webapp.escola_xyz_b.Model.Administrador; // Importa a classe Administrador

public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
    // Interface para realizar operações CRUD (Create, Read, Update, Delete) no banco de dados para a entidade Administrador

    Administrador findByCpf(String cpf); // Método para buscar um administrador pelo CPF.
    boolean existsByCpf(String cpf); // Método para verificar se um administrador com o CPF fornecido existe no banco de dados.
}
