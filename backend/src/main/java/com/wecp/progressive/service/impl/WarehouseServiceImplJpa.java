package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.exception.NoWarehouseFoundForSupplierException;
import com.wecp.progressive.repository.ProductRepository;
import com.wecp.progressive.repository.ShipmentRepository;
import com.wecp.progressive.repository.WarehouseRepository;
import com.wecp.progressive.service.WarehouseService;

@Service
public class WarehouseServiceImplJpa  implements WarehouseService{

    @Autowired
    WarehouseRepository warehouseRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    @Autowired
    ProductRepository productRepository;

    

    public WarehouseServiceImplJpa(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
        return warehouse.getWarehouseId();
        
    }

    @Override
    public void deleteWarehouse(int warehouseId)  {
        // shipmentRepository.deleteByWarehouseId(warehouseId);
        // productRepository.deleteByWarehouseId(warehouseId);
        warehouseRepository.deleteById(warehouseId);
    }

    @Override
    public List<Warehouse> getAllWarehouses()  {
        
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse getWarehouseById(int warehouseId)  {
        return warehouseRepository.findByWarehouseId(warehouseId);
    }

    @Override
    public List<Warehouse> getWarehouseBySupplier(int supplierId) {

       if(warehouseRepository.findAllBySupplier_SupplierId(supplierId).isEmpty()){
        throw new NoWarehouseFoundForSupplierException("No warehouse found");
       }else{
        return warehouseRepository.findAllBySupplier_SupplierId(supplierId);
       }
    }

    @Override
    public List<Warehouse> getWarehousesSortedByCapacity()  {
        List<Warehouse> sortWarehouses = getAllWarehouses();
        sortWarehouses.sort(Comparator.comparing(Warehouse::getCapacity).reversed());
        return sortWarehouses;
    }

    @Override
    public void updateWarehouse(Warehouse warehouse)  {

        Warehouse w = warehouseRepository.findById(warehouse.getWarehouseId()).get();

        if(w!=null){
            w.setWarehouseId(warehouse.getWarehouseId());
            w.setSupplierId(warehouse.getSupplierId());
            w.setCapacity(warehouse.getCapacity());
            w.setWarehouseName(warehouse.getWarehouseName());
            w.setLocation(warehouse.getLocation());
            w.setSupplier(warehouse.getSupplier());
            warehouseRepository.save(w);
        }

    }

}