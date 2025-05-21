package com.easybuy.repository;

import com.easybuy.model.Categoria;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
