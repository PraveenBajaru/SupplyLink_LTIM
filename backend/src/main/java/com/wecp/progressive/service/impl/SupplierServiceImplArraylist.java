package com.wecp.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wecp.progressive.dao.SupplierDAO;
import com.wecp.progressive.entity.Supplier;
import com.wecp.progressive.entity.Warehouse;
import com.wecp.progressive.service.SupplierService;

@Service
public class SupplierServiceImplArraylist implements SupplierService {

    private List<Supplier>ans=new ArrayList<>();
    @Override
    public int addSupplier(Supplier supplier) {
        ans.add(supplier);
        return ans.size();
    }

    @Override
    public List<Supplier> getAllSuppliers() {
     //List<Supplier> ans=new ArrayList<>();
        return ans;
    }

  

 @Override
    public List<Supplier> getAllSuppliersSortedByName() {
        //List<Supplier> ans=new ArrayList<>();
        // Collections.sort(ans);
        // Collections.sort(ans,new Supplier());
        // return ans;
        List<Supplier> sortedSupplier=ans;
        sortedSupplier.sort(Comparator.comparing(Supplier::getSupplierName));
        return sortedSupplier;

    }
    public void emptyArrayList()
    {
        ans.clear();
    }
   
    
}