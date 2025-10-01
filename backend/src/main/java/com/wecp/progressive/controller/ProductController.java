package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Product;
import com.wecp.progressive.service.impl.ProductServiceImplJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImplJpa productServiceImplJpa;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() //throws SQLException 
    {
        return new ResponseEntity<>(productServiceImplJpa.getAllProducts(),HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) //throws SQLException 
    {
        return new ResponseEntity<>(productServiceImplJpa.getProductById(productId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> addProduct(@RequestBody Product product) //throws SQLException 
    {
        return new ResponseEntity<>(productServiceImplJpa.addProduct(product),HttpStatus.CREATED);
    }

    public ResponseEntity<Void> updateProduct(int productId, Product product) 
    {
        return null;
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {
        productServiceImplJpa.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Product>> getAllProductByWarehouse(@PathVariable int warehouseId) {
       return new ResponseEntity<>(productServiceImplJpa.getAllProductByWarehouse(warehouseId),HttpStatus.OK);
    }
}
