package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.exception.SupplierAlreadyExistsException;
import com.wecp.progressive.exception.SupplierDoesNotExistException;
import com.wecp.progressive.repository.SupplierRepository;
import com.wecp.progressive.service.SupplierService;

@Service
public class SupplierServiceImplJpa  implements SupplierService{

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public SupplierServiceImplJpa(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @Override
    public int addSupplier(Supplier supplier)  {

        Supplier existingUsername = supplierRepository.findByUsername(supplier.getUsername());

        if(existingUsername!=null){
            throw new SupplierAlreadyExistsException("Supplier Username already exists");
        }

        Supplier existingEmail = supplierRepository.findByEmail(supplier.getEmail());

        if(existingEmail!=null){
            throw new SupplierAlreadyExistsException("Supplier Email already exists");
        }

        supplier.setPassword(passwordEncoder.encode(supplier.getPassword()));
        return supplierRepository.save(supplier).getSupplierId();
        
    }

    @Override
    public List<Supplier> getAllSuppliers()throws SQLException{
        return supplierRepository.findAll();
    }

    @Override
    public List<Supplier> getAllSuppliersSortedByName() throws SQLException{
        List<Supplier> sortSuppliers = supplierRepository.findAll();
        sortSuppliers.sort(Comparator.comparing(Supplier::getSupplierName));
        return sortSuppliers;
    }
    public void updateSupplier(Supplier supplier)throws SQLException
    {
        Supplier s = supplierRepository.findById(supplier.getSupplierId()).get();

        if(s!=null){
            s.setSupplierName(supplier.getSupplierName());
            s.setAddress(supplier.getAddress());
            s.setEmail(supplier.getEmail());
            s.setPassword(supplier.getPassword());
            s.setPhone(supplier.getPhone());
            s.setRole(supplier.getRole());

            List<Supplier> sList = supplierRepository.findAll();

            for(Supplier sup : sList){

                if(sup.getUsername()==supplier.getUsername()){
                    throw new SupplierAlreadyExistsException("Supplier already exists");
                }

            }

            supplierRepository.save(s);
        }

    }
    public void deleteSupplier(int supplierId)throws SQLException
    {
        supplierRepository.deleteById(supplierId);

    }

    public Supplier getSupplierById(int supplierId) throws SQLException {

        if(supplierRepository.existsById(supplierId)){
            return supplierRepository.findBySupplierId(supplierId);
        }else{
            throw new SupplierDoesNotExistException("Supplier does not exist");
        }

    }

}