package com.wecp.progressive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
    // Product findByProductId(@Param("productId")int productId);
    //@Query("Select p from Product p ")
     List<Product> findAllByWarehouse_WarehouseId(@Param("warehouseId") int warehouseId);
    // Void deleteByWareHouseId(@Param("warehouseId")int warehouseId);
    // Void deleteBySupplierId(@Param("supplierId")int supplierId);

    
}
