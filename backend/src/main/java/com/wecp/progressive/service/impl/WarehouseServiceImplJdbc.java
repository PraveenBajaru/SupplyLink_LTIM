package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.wecp.progressive.dao.WarehouseDAO;
import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.service.WarehouseService;

public class WarehouseServiceImplJdbc  implements WarehouseService{
private WarehouseDAO warehouseDAO;

public WarehouseServiceImplJdbc(WarehouseDAO warehouseDAO) {
    this.warehouseDAO = warehouseDAO;
}
 @Override
    public int addWarehouse(Warehouse warehouse)throws SQLException {
        
        return warehouseDAO.addWarehouse(warehouse);
    }

    @Override
    public List<Warehouse> getAllWarehouses() throws SQLException{
       //List<Warehouse>ans=new ArrayList<>();
       return warehouseDAO.getAllWarehouse();
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() throws SQLException{
        List<Warehouse> sortWarehouses=warehouseDAO.getAllWarehouse();
        sortWarehouses.sort(Comparator.comparing(Warehouse::getCapacity));
        return sortWarehouses;
    }
    public void updateWarehouse(Warehouse warehouse)throws SQLException
    {
       warehouseDAO.updateWarehouse(warehouse);
    }
    public void deleteWarehouse(int warehouseId)throws SQLException
    {
 warehouseDAO.deleteWarehouse(warehouseId);
    }
    public Warehouse getWarehouseById(int warehouseId)throws SQLException
    {
        return warehouseDAO.getWarehouseById(warehouseId);
    }
//     public List<Warehouse> getWarehouseBySupplier(int supplierId) {
//     //List<Warehouse>ans=new ArrayList<>();
//       return null;
//    }
}