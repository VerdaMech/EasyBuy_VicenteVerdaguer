package com.easybuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.easybuy.model.ProductosCategorias;

@Repository
public interface ProductosCategoriasRepository extends JpaRepository<ProductosCategorias,Long>{

}
