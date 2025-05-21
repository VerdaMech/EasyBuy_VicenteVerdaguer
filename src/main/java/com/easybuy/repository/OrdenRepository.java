package com.easybuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.easybuy.model.Orden;

@Repository
public interface OrdenRepository extends JpaRepository<Orden,Long> {

}
