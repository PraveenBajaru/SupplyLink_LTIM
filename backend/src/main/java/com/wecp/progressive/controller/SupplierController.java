package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.repository.SupplierRepository;
import com.wecp.progressive.service.SupplierService;
import com.wecp.progressive.service.impl.SupplierServiceImplArraylist;
import com.wecp.progressive.service.impl.SupplierServiceImplJpa;

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
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierServiceImplArraylist supplierServiceImplArraylist;

    private SupplierServiceImplJpa supplierServiceImplJpa;
    @Autowired
    SupplierController(SupplierServiceImplJpa supplierServiceImplJpa)
    {
        this.supplierServiceImplJpa=supplierServiceImplJpa;
    }

    
    @GetMapping
    public ResponseEntity<List<Supplier>> getAllSuppliers() throws SQLException {
        List<Supplier> suppliers = supplierServiceImplJpa.getAllSuppliers();
        return new ResponseEntity<>(suppliers ,HttpStatus.OK);
    }
    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable int supplierId)throws SQLException{
         return new ResponseEntity<>(supplierServiceImplJpa.getSupplierById(supplierId) , HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Integer> addSupplier(@RequestBody Supplier supplier)throws SQLException {
        supplierServiceImplJpa.addSupplier(supplier);
        return new ResponseEntity<>(supplier.getSupplierId() , HttpStatus.CREATED);
    }
    @PutMapping("/{supplierId}")
    public ResponseEntity<Void> updateSupplier(@PathVariable int supplierId , @RequestBody Supplier supplier)throws SQLException{
             supplier.setSupplierId(supplierId);
            supplierServiceImplJpa.updateSupplier(supplier);
            return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{supplierId}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int supplierId)throws SQLException{
            supplierServiceImplJpa.deleteSupplier(supplierId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Supplier>> getAllSuppliersFromArrayList() {
        return new ResponseEntity<>(supplierServiceImplArraylist.getAllSuppliers(),HttpStatus.OK);
    }
    @PostMapping("/toArrayList")
    public ResponseEntity<Integer> addSupplierToArrayList(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(supplierServiceImplArraylist.addSupplier(supplier),HttpStatus.CREATED);
    }
    @GetMapping("/fromArrayList/all")
    public ResponseEntity<List<Supplier>> getAllSuppliersSortedByNameFromArrayList() {
        return new ResponseEntity<>(supplierServiceImplArraylist.getAllSuppliersSortedByName(),HttpStatus.OK);
    }
}