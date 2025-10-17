package com.wecp.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wecp.progressive.config.DatabaseConnectionManager;
import com.wecp.progressive.entity.Product;
import com.wecp.progressive.entity.Supplier;

public class SupplierDAOImpl implements SupplierDAO{

   

    @Override
    public int addSupplier(Supplier supplier) throws SQLException{
       String query="Insert into supplier(supplier_name,username,password,email,phone,address,role)values(?,?,?,?,?,?,?)";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
        {
            ps.setString(1,supplier.getSupplierName() );
            ps.setString(2,supplier.getEmail());
            ps.setString(3,supplier.getPassword());
            ps.setString(4,supplier.getUsername());
            ps.setString(5,supplier.getPhone());
            ps.setString(6,supplier.getAddress());
            ps.setString(7,supplier.getRole());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next())
            {
                supplier.setSupplierId(rs.getInt(1));
                return rs.getInt(1);
            }
        }
        return -1;
    }

    @Override
    public void deleteSupplier(int supplierId) throws SQLException{
        String query="Delete from supplier where supplier_id=?";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps=connection.prepareStatement(query))
        {
          ps.setInt(1, supplierId);
          ps.executeUpdate();
        }
        
    }

    @Override
    public List<Supplier> getAllSuppliers() throws SQLException{
        List<Supplier>suppliers=new ArrayList<>();
        String query="Select * from supplier";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery())
        {
            while(rs.next())
            {
                Supplier supplier=new Supplier(
                    rs.getInt("supplier_id"),
                    rs.getString("supplier_name"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("role")
                );
                suppliers.add(supplier);
            }
        }
        return suppliers;
    }

    @Override
    public Supplier getSupplierById(int supplierId) throws SQLException{
        String query="Select * from supplier where supplier_id=?";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps=connection.prepareStatement(query))
        {
        ps.setInt(1, supplierId);
        ResultSet rs=ps.executeQuery();
         if ((rs.next())) {
            return new Supplier(
                    rs.getInt("supplier_id"),
                    rs.getString("supplier_name"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("address"),
                    rs.getString("role")
                );
         }
        }
        return null;
    }

    @Override
    public void updateSupplier(Supplier supplier) throws SQLException{
        String query="Update supplier set supplier_name =?,username=? where supplier_id=?";
        try(Connection connection=DatabaseConnectionManager.getConnection();
       PreparedStatement ps=connection.prepareStatement(query))
       {
         ps.setString(1,supplier.getSupplierName() );
         ps.setString(2,supplier.getEmail());
        ps.setInt(3, supplier.getSupplierId());
        ps.executeUpdate();
       }
    }



}
