package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.dao.ProductDAO;
import com.wecp.progressive.entity.Product;
import com.wecp.progressive.service.ProductService;

public class ProductServiceImplJdbc implements ProductService  {
    private ProductDAO productDAO;

    public ProductServiceImplJdbc(ProductDAO productDAO)
    {
        this.productDAO=productDAO;
    }

    @Override
    public int addProduct(Product product) throws SQLException{
        // TODO Auto-generated method stub
        return productDAO.addProduct(product);
    }

    @Override
    public void deleteProduct(int productId) throws SQLException{
        // TODO Auto-generated method stub
        productDAO.deleteProduct(productId);
    }

    @Override
    public List<Product> getAllProducts() throws SQLException{
        // TODO Auto-generated method stub
        return productDAO.getAllProducts();
    }

    @Override
    public Product getProductById(int productId) throws SQLException{
        // TODO Auto-generated method stub
        return productDAO.getProductById(productId);
    }

    @Override
    public void updateProduct(Product product) throws SQLException{
        // TODO Auto-generated method stub
        
        productDAO.updateProduct(product);
    }



}