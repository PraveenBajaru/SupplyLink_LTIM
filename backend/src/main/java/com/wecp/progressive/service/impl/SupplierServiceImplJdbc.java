package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wecp.progressive.dao.SupplierDAO;
import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.service.SupplierService;

public class SupplierServiceImplJdbc implements SupplierService {

    //private List<Supplier>ans=new ArrayList<>();
    SupplierDAO supplierDAO;
   // @Autowired
    //SupplierService supplierService;

    public SupplierServiceImplJdbc(SupplierDAO supplierDAO) {
        this.supplierDAO = supplierDAO;
        //this.supplierService=supplierService;
    }
    

     @Override
    public int addSupplier(Supplier supplier) throws SQLException {
      
       return supplierDAO.addSupplier(supplier);
    }


    @Override
    public List<Supplier> getAllSuppliers() throws SQLException{
        //List<Supplier>ans=new ArrayList<>();
        //return ans;
        //return List.of();
        return supplierDAO.getAllSuppliers();
    }


    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException {
        List<Supplier> sortedSupplier=supplierDAO.getAllSuppliers();
        sortedSupplier.sort(Comparator.comparing(Supplier::getSupplierName));
        return sortedSupplier;
    }


    public void updateSupplier(Supplier supplier) throws SQLException
    {
       supplierDAO.updateSupplier(supplier);
    }
    public void deleteSupplier(int supplierId) throws SQLException
    {
       supplierDAO.deleteSupplier(supplierId);
    }
    public Supplier getSupplierById(int supplierId)throws SQLException
    {
        return supplierDAO.getSupplierById(supplierId);
    }
}