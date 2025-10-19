package com.wecp.progressive.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Shipment;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment , Integer>{

    Shipment findByShipmentId(int shipmentId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Shipment s WHERE s.warehouse.warehouseId = :warehouseId")
    void deleteByWarehouseId(int warehouseId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Shipment s WHERE s.product.productId = :productId")
    void deleteByProductId(int productId);


    @Modifying
    @Transactional
    @Query("DELETE FROM Shipment s WHERE s.warehouse.supplierId = :supplierId")
    void deleteBySupplierId(int supplierId);

}
