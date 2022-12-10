package org.ada.mypocketbalance.repository;

import org.ada.mypocketbalance.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
