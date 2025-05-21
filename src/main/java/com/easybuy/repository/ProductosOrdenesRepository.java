package com.easybuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easybuy.model.ProductosOrdenes;


@Repository
public interface ProductosOrdenesRepository extends JpaRepository<ProductosOrdenes, Long>{

}
