package org.ada.mypocketbalance.repository;

import org.ada.mypocketbalance.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura,Integer> {
}
