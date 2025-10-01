package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.service.impl.WarehouseServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseServiceImplJpa warehouseServiceImplJpa;
    @GetMapping
    public ResponseEntity<List<Warehouse>> getAllWarehouses() {
        return null;
    }
    @GetMapping("/{warehouseId}")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable int warehouseId) {
        return null;
    }
    @PostMapping
    public ResponseEntity<Integer> addWarehouse(Warehouse warehouse) {
        return new ResponseEntity<>(warehouseServiceImplJpa.addWarehouse(warehouse),HttpStatus.CREATED);
    }
    @PutMapping("/{warehouseId}")
    public ResponseEntity<Void> updateWarehouse(int warehouseId, Warehouse warehouse) {
        return null;
    }

    public ResponseEntity<Void> deleteWarehouse(int warehouseId) {
        return null;
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<Warehouse>> getWarehousesBySupplier( @PathVariable int supplierId) {
        return new ResponseEntity<>(warehouseServiceImplJpa.getWarehouseBySupplier(supplierId),HttpStatus.OK);
    }
    

}
