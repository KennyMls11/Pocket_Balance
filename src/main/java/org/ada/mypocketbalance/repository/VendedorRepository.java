package org.ada.mypocketbalance.repository;

import org.ada.mypocketbalance.entity.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor,Integer> {

}
