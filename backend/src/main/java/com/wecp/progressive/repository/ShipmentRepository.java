package com.wecp.progressive.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wecp.progressive.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment,Integer> {
    //@Query("Select s from Shipment s where s.shipmentDate=:shipmentDate")
    Shipment findByShipmentId(int shipmentID);
    //void deleteByWarehouseId(int warehouseId);
    //void deleteBySupplierId(int supplierId);
}