package com.easybuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easybuy.model.Pago;


@Repository
public interface PagoRepository extends JpaRepository<Pago, Long>{

}
