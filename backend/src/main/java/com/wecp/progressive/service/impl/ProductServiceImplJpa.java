package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Product;
import com.wecp.progressive.repository.ProductRepository;
import com.wecp.progressive.service.ProductService;

@Service
public class ProductServiceImplJpa  implements ProductService{

    @Autowired
    ProductRepository productRepository;

    public ProductServiceImplJpa(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public int addProduct(Product product) throws SQLException {

        productRepository.save(product);
        return product.getProductId();
        

    }

    @Override
    public void deleteProduct(int productId) throws SQLException {
        productRepository.deleteById(productId);
        
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
       return productRepository.findById(productId).get();
    }

    @Override
    public void updateProduct(Product product) throws SQLException {
       
        Product p = productRepository.findById(product.getProductId()).get();

        if(p!=null){
            p.setProductName(product.getProductName());
            p.setPrice(product.getPrice());
            p.setProductDescription(product.getProductDescription());
            p.setQuantity(product.getQuantity());
            p.setWarehouse(product.getWarehouse());
            productRepository.save(p);
        }
        
    }

    @Override
    public List<Product> getAllProductByWarehouse(int warehouseId)throws SQLException {
        
        return productRepository.findAllByWarehouse_WarehouseId(warehouseId);
    }

    

}