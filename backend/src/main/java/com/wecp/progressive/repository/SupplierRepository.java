package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Supplier;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer>{

   // @Query("Delete from Supplier s where s.supplierId=:supplierId")
   @Query("Select s from Supplier s where s.supplierId=:supplierId")
    Supplier findBySupplierId(@Param("supplierId") int supplierId);

    Supplier findByUsername(String username);
    Supplier findByEmail(String email);
    
}
