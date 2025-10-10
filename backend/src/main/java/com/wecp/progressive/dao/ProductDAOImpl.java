package com.wecp.progressive.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Product;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public int addProduct(Product product) throws SQLException{
        String query="Insert into product(warehouse_id,product_name,product_description,quantity,price)values(?,?,?,?,?)";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
        {
        ps.setInt(1, product.getWarehouseId());
        ps.setString(2,product.getProductName());
        ps.setString(3, product.getProductDescription());
        ps.setInt(4, product.getQuantity());
        ps.setLong(5, product.getPrice());
        ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next())
        {
          product.setProductId(rs.getInt(1));
          return rs.getInt(1);
        }
        }
        return -1;
    }

    @Override
    public void deleteProduct(int productId) throws SQLException{
        String query="Delete from product where product_id=?";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps=connection.prepareStatement(query))
        {
          ps.setInt(1, productId);
          ps.executeUpdate();
        }
    }

    @Override
    public List<Product> getAllProducts() throws SQLException{
       List<Product>products=new ArrayList<>();
       String query="Select * from product";
       try(Connection connection=DatabaseConnectionManager.getConnection();
       PreparedStatement ps=connection.prepareStatement(query);
       ResultSet rs=ps.executeQuery())
       {
        while ((rs.next())) {
          Product product=new Product(
            rs.getInt("product_id"),
            rs.getInt("warehouse_id"),
            rs.getString("product_name"),
            rs.getString("product_description"),
            rs.getInt("quantity"),
            rs.getLong("price")
          );
          products.add(product);      
        }
       }
       return products;
    }

    @Override
    public Product getProductById(int productId) throws SQLException{
      String query="Select * from product where product_id=?";
       try(Connection connection=DatabaseConnectionManager.getConnection();
       PreparedStatement ps=connection.prepareStatement(query))
       {
       ps.setInt(1, productId);
       ResultSet rs=ps.executeQuery();
        if ((rs.next())) {
          Product product=new Product(
            rs.getInt("product_id"),
            rs.getInt("warehouse_id"),
            rs.getString("product_name"),
            rs.getString("product_description"),
            rs.getInt("quantity"),
            rs.getLong("price")
          );
          return product;
        }
      }
      return null;
    }

    @Override
    public void updateProduct(Product product) throws SQLException{
        String query="Update product set warehouse_id=?,product_name=?,product_description=?,quantity=?,price=? where product_id=?";
        try(Connection connection=DatabaseConnectionManager.getConnection();
       PreparedStatement ps=connection.prepareStatement(query))
       {
        ps.setInt(1, product.getWarehouseId());
        ps.setString(2,product.getProductName());
        ps.setString(3, product.getProductDescription());
        ps.setInt(4, product.getQuantity());
        ps.setLong(5, product.getPrice());
        ps.setInt(6, product.getProductId());
        ps.executeUpdate();
       }
    }

}
