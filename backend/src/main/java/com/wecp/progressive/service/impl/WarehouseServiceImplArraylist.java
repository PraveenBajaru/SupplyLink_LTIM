package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.repository.WarehouseRepository;
import com.wecp.progressive.service.WarehouseService;

public class WarehouseServiceImplArraylist implements WarehouseService {


   

    
    List<Warehouse>ans=new ArrayList<>();
    @Override
    public int addWarehouse(Warehouse warehouse) {
      ans.add(warehouse);
      return ans.size();
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
       return ans;
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity() {
        //List<Warehouse>ans=new ArrayList<>();
        List<Warehouse> sortWarehouses=ans;
        sortWarehouses.sort(Comparator.comparing(Warehouse::getCapacity));
        return sortWarehouses;
       
    }
    public void emptyArrayList()
    {
        ans.clear();
    }
    

}