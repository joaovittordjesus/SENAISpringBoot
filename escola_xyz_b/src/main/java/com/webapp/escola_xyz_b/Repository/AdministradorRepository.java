package com.webapp.escola_xyz_b.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.webapp.escola_xyz_b.Model.Administrador;



public interface AdministradorRepository extends CrudRepository<Administrador, String> {
    //Caso metodo extra = true (criar aqui)
    Administrador findByCpf(String cpf);

    //Querry especifica
    //@Querry()
}
