package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.repository.CrudRepository;
import com.webapp.escola_xyz_b.Model.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, Long> {
    Administrador findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
