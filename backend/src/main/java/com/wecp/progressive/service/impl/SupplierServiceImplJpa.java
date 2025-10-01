package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Product;
import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.exception.SupplierAlreadyExistsException;
import com.wecp.progressive.repository.SupplierRepository;
import com.wecp.progressive.service.SupplierService;
@Service
public class SupplierServiceImplJpa  implements SupplierService{

    @Autowired
    SupplierRepository supplierRepository;
    
    public SupplierServiceImplJpa(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public int addSupplier(Supplier supplier) 
    {
        if(supplierRepository.findByEmail(supplier.getEmail())!=null)
        {
         throw new SupplierAlreadyExistsException(null);
        }
        if(supplierRepository.findByUsername(supplier.getUsername())!=null)
        {
            throw new SupplierAlreadyExistsException(null);
        }
        supplierRepository.save(supplier);
        return supplier.getSupplierId();
    }

    @Override
    public List<Supplier> getAllSuppliers()  
    {
       return supplierRepository.findAll();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName()
    {
         List<Supplier> sortedSupplier=getAllSuppliers();
        sortedSupplier.sort(Comparator.comparing(Supplier::getSupplierName));
        return sortedSupplier;
    }
    public void updateSupplier(Supplier supplier) 
    {
       Supplier s=supplierRepository.findById(supplier.getSupplierId()).get();
       if(s!=null)
       {
        s.setSupplierName(supplier.getSupplierName());
        s.setUsername(supplier.getUsername());
        s.setPassword(supplier.getPassword());
        s.setEmail(supplier.getEmail());
        s.setPhone(supplier.getPhone());
        s.setRole(supplier.getRole());
        supplierRepository.save(s);
       }
    }
    public void deleteSupplier(int supplierId)
    {
        supplierRepository.deleteById(supplierId);
    }
    public Supplier getSupplierById(int supplierId)
     {
       return supplierRepository.findBySupplierId(supplierId);
    }
   
}