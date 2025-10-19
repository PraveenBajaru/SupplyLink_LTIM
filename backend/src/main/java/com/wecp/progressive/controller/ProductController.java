package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Product;
import com.wecp.progressive.service.ProductService;
import com.wecp.progressive.service.WarehouseService;
import com.wecp.progressive.service.impl.ProductServiceImplJpa;
import com.wecp.progressive.service.impl.WarehouseServiceImplJpa;

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
    private ProductServiceImplJpa productServiceImplJpa;

    @Autowired
    private WarehouseServiceImplJpa warehouseServiceIJpa;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        try{
        return new ResponseEntity<>(productServiceImplJpa.getAllProducts() , HttpStatus.OK);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        try{

            if(productServiceImplJpa.getProductById(productId)==null){

                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else{
            return new ResponseEntity<>(productServiceImplJpa.getProductById(productId) , HttpStatus.OK);
            }

        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Integer> addProduct(@RequestBody Product product) {
        try{
            productServiceImplJpa.addProduct(product);
            return new ResponseEntity<>(product.getProductId() , HttpStatus.CREATED);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Void> updateProduct(int productId, Product product) {
        return null;
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int productId) {

        try{

           
                productServiceImplJpa.deleteProduct(productId);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            

        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/warehouse/{warehouseId}")
    public ResponseEntity<List<Product>> getAllProductByWarehouse(@PathVariable int warehouseId) throws SQLException{

      
            return new ResponseEntity<>(productServiceImplJpa.getAllProductByWarehouse(warehouseId) , HttpStatus.OK);
        
    

    }
}
