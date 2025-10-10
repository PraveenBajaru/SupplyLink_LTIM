package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Shipment;
import com.wecp.progressive.service.impl.ShipmentServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentServiceImpl shipmentServiceImpl;

    @GetMapping
    public ResponseEntity<List<Shipment>> getAllShipments() {
        try{
        return new ResponseEntity<>(shipmentServiceImpl.getAllShipments() , HttpStatus.OK);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{shipmentId}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable int shipmentId) {
        try{
            if(shipmentServiceImpl.getShipmentById(shipmentId)!=null){
                return new ResponseEntity<>(shipmentServiceImpl.getShipmentById(shipmentId) , HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addShipment(@RequestBody Shipment shipment) {
        try{    
            shipmentServiceImpl.addShipment(shipment);
            return new ResponseEntity<>(shipment.getShipmentId() , HttpStatus.CREATED);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{shipmentId}")
    public ResponseEntity<Void> updateShipment(@PathVariable int shipmentId, @RequestBody Shipment shipment) {
        try{
            Shipment s = shipmentServiceImpl.getShipmentById(shipmentId);
            shipmentServiceImpl.updateShipment(shipment);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{shipmentId}")
    public ResponseEntity<Void> deleteShipment(@PathVariable int shipmentId) {

        try{
            shipmentServiceImpl.deleteShipment(shipmentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
