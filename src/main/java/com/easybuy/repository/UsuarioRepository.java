package com.easybuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.easybuy.model.Usuario;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{


    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nombre) LIKE CONCAT(:letra, '%')")
    List<Usuario> buscarUsuariosPorLetraInicial(@Param("letra") String letra);

}
