package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.service.SupplierService;
import com.wecp.progressive.service.impl.SupplierServiceImplArraylist;
import com.wecp.progressive.service.impl.SupplierServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/supplier")
public class SupplierController {
    SupplierServiceImplArraylist supplierServiceImplArraylist;
    @Autowired
    SupplierServiceImplJpa supplierServiceImplJpa;
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() //throws SQLException  
    {
        return new ResponseEntity<>(supplierServiceImplJpa.getAllSuppliers(),HttpStatus.OK);
    }
    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(int supplierId) //throws SQLException 
     {
        Supplier s=supplierServiceImplJpa.getSupplierById(supplierId);
       return new ResponseEntity<>(s,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier) //throws SQLException 
    {
        supplierServiceImplJpa.addSupplier(supplier);
        return new ResponseEntity<>(supplier.getSupplierId(),HttpStatus.CREATED);
    }
     @PutMapping("/{supplierId}")
    public ResponseEntity<Void> updateSupplier(@RequestBody Supplier supplier) //throws SQLException 
    {
        supplierServiceImplJpa.updateSupplier(supplier);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(int supplierId) {
        supplierServiceImplJpa.deleteSupplier(supplierId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        return new ResponseEntity<>(supplierServiceImplArraylist.getAllSuppliers(),HttpStatus.OK);
    }
    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(Supplier supplier) {
        return new ResponseEntity<>(supplierServiceImplArraylist.addSupplier(supplier),HttpStatus.CREATED);
    }
    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        return new ResponseEntity<>(supplierServiceImplArraylist.getAllSuppliersSortedByName(),HttpStatus.OK);
    }
}