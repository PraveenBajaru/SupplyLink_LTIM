package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.service.WarehouseService;
import com.wecp.progressive.service.impl.WarehouseServiceImplJpa;

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

import java.util.List;

import javax.persistence.PostRemove;
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseServiceImplJpa warehouseServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return new ResponseEntity<>(warehouseServiceImplJpa.getAllWarehouses() , HttpStatus.OK);
    }

    @GetMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int warehouseId) {
        return new ResponseEntity<>(warehouseServiceImplJpa.getWarehouseById(warehouseId),HttpStatus.OK);
    }   

    @PostMapping
    public ResponseEntity<Integer> addWarehouse(@RequestBody Warehouse warehouse) {
        return new ResponseEntity<>(warehouseServiceImplJpa.addWarehouse(warehouse) , HttpStatus.CREATED);
    }

    @PutMapping("/{warehouseId}")
    public ResponseEntity<Void> updateWarehouse(@PathVariable int warehouseId, @RequestBody Warehouse warehouse) {
        warehouseServiceImplJpa.updateWarehouse(warehouse);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{warehouseId}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int warehouseId) {
        warehouseServiceImplJpa.deleteWarehouse(warehouseId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier(@PathVariable int supplierId) {
        return new ResponseEntity<>(warehouseServiceImplJpa.getWarehouseBySupplier(supplierId) , HttpStatus.OK);
    }
}
