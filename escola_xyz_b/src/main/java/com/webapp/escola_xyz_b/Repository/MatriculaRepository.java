package com.webapp.escola_xyz_b.Repository;

import com.webapp.escola_xyz_b.Model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
//Implementar metodos personalizados de consulta ao banco de dados se necessário.
}
