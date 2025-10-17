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
import com.wecp.progressive.entity.Warehouse;

public class WarehouseDAOImpl implements WarehouseDAO{

  

    @Override
    public int addWarehouse(Warehouse warehouse)throws SQLException {
        String query="Insert into warehouse(supplier_id,warehouse_name,location,capacity)values(?,?,?,?)";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS))
        {
            ps.setInt(1, warehouse.getSupplierId());
            ps.setString(2,warehouse.getWarehouseName());
            ps.setString(3, warehouse.getLocation());
            ps.setInt(4, warehouse.getCapacity());
         ps.executeUpdate();
        ResultSet rs=ps.getGeneratedKeys();
        if(rs.next())
        {
         warehouse.setWarehouseId(rs.getInt(1));
          return rs.getInt(1);
        }
        }
        return -1;
    }

    @Override
    public void deleteWarehouse(int warehouseId) throws SQLException{
        String query="Delete from warehouse where warehouse_id=?";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps=connection.prepareStatement(query))
        {
          ps.setInt(1, warehouseId);
          ps.executeUpdate();
        }
        
    }

    @Override
    public List<Warehouse> getAllWarehouse() throws SQLException{
        List<Warehouse>warehouses=new ArrayList<>();
       String query="Select * from warehouse";
       try(Connection connection=DatabaseConnectionManager.getConnection();
       PreparedStatement ps=connection.prepareStatement(query);
       ResultSet rs=ps.executeQuery())
       {
        while ((rs.next())) {
            Warehouse warehouse=new Warehouse(
              rs.getInt("warehouse_id"),
              rs.getInt("supplier_id"),
              rs.getString("warehouse_name"),
              rs.getString("location"),
              rs.getInt("capacity")
            );
            warehouses.add(warehouse);
        }
    }
    return warehouses;
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId) throws SQLException{
        String query="Select * from warehouse where warehouse_id=?";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps=connection.prepareStatement(query))
        {
            ps.setInt(1, warehouseId);
            ResultSet rs=ps.executeQuery();
            if ((rs.next())) {
                Warehouse warehouse= new Warehouse(
              rs.getInt("warehouse_id"),
              rs.getInt("supplier_id"),
              rs.getString("warehouse_name"),
              rs.getString("location"),
              rs.getInt("capacity")
            );
            return warehouse;
            }
        }
        return null;

    }

    @Override
    public void updateWarehouse(Warehouse warehouse)throws SQLException {
        String query="Update warehouse set supplier_id=?,warehouse_name=?,location=?,capacity=? where warehouse_id=?";
        try(Connection connection=DatabaseConnectionManager.getConnection();
        PreparedStatement ps = connection.prepareStatement(query))
        {
            ps.setInt(1, warehouse.getSupplierId());
            ps.setString(2,warehouse.getWarehouseName());
            ps.setString(3, warehouse.getLocation());
            ps.setInt(4, warehouse.getCapacity());
            ps.setInt(5, warehouse.getWarehouseId());
             ps.executeUpdate();
        }
        
    }

    

    
    
}
