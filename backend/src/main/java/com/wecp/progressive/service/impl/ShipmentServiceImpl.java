package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Shipment;
import com.wecp.progressive.repository.ShipmentRepository;

@Service
public class ShipmentServiceImpl  {

    @Autowired
    ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public List<Shipment> getAllShipments()throws SQLException{

        return shipmentRepository.findAll();

    }

    public Shipment getShipmentById(int shipmentId)throws SQLException{
        return shipmentRepository.findByShipmentId(shipmentId);
    }

    public int addShipment(Shipment shipment)throws SQLException{

        shipmentRepository.save(shipment);
        return shipment.getShipmentId();

    }

    public void updateShipment(Shipment shipment)throws SQLException{

        Shipment Existingshipment = shipmentRepository.findById(shipment.getShipmentId()).get();

        Existingshipment.setSourceLocation(shipment.getSourceLocation());
        Existingshipment.setDestinationLocation(shipment.getDestinationLocation());
        Existingshipment.setExpectedDeliveryDate(shipment.getExpectedDeliveryDate());
        Existingshipment.setShipmentDate(shipment.getShipmentDate());
        Existingshipment.setStatus(shipment.getStatus());
        Existingshipment.setWarehouse(shipment.getWarehouse());
        Existingshipment.setProduct(shipment.getProduct());

        shipmentRepository.save(Existingshipment);

    }

    public void deleteShipment(int shipmentId)throws SQLException{

        shipmentRepository.deleteById(shipmentId);

    }

    

}