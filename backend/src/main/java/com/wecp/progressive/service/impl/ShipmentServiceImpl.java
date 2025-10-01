package com.wecp.progressive.service.impl;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Shipment;
import com.wecp.progressive.repository.ShipmentRepository;
import com.wecp.progressive.service.ShipmentService;

@Service
public class ShipmentServiceImpl implements ShipmentService  {

    @Autowired
    ShipmentRepository shipmentRepository;
    @Override
    public int addShipment(Shipment shipment) {
       shipmentRepository.save(shipment);
       return shipment.getShipmentId();
    }

    @Override
    public void deleteShipment(int shipmentId) {
      // shipmentRepository.deleteById( shipmentId);
        
    }

    @Override
    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    @Override
    public Shipment getShipmentById(int shipmentId) throws SQLException{

        return shipmentRepository.findByShipmentId(shipmentId);
    }

    @Override
    public void updateShipment(Shipment shipment) {
        // Shipment s=shipmentRepository.findById(shipment.getShipmentId()).get();
        // s.setDestinationLocation(shipment.getDestinationLocation());
        // s.setExpectedDeliveryDate(shipment.getExpectedDeliveryDate());
        // s.setShipmentDate(shipment.getShipmentDate());
        // s.setProduct(shipment.getProduct());
        // s.setSourceLocation(shipment.getSourceLocation());
        // s.setStatus(shipment.getStatus());
        // s.setWarehouse(shipment.getWarehouse());
    }
}