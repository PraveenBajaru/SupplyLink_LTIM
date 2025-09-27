package com.wecp.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Warehouse;
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse,Integer>{
    
    // Warehouse findByWarehouseId(int warehouseId);
    // @Query("Select w from Warehouse w join fetch w.supplier")
     List<Warehouse> findAllBySupplier_SupplierId(int supplierId);

    // Void deleteBySupplierId(int supplierId);


}
