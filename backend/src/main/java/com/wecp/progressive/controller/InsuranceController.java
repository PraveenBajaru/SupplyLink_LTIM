package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Insurance;
import com.wecp.progressive.entity.Shipment;
import com.wecp.progressive.service.impl.InsuranceServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    InsuranceServiceImpl insuranceServiceImpl;

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances() {
        try{
       return new ResponseEntity<>(insuranceServiceImpl.getAllInsurances(),HttpStatus.OK);
        }
        catch(SQLException e)
    {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @GetMapping("/{insuranceId}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable int insuranceId) {
       try{
        Insurance in=insuranceServiceImpl.getInsuranceById(insuranceId);
        if(in==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(in,HttpStatus.OK);
    }
    catch(SQLException e)
    {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @PostMapping
    public ResponseEntity<Integer> createInsurance(@RequestBody Insurance insurance) {
        return new ResponseEntity<>(insuranceServiceImpl.addInsurance(insurance),HttpStatus.CREATED);
    }

    public ResponseEntity<Void> updateInsurance(int insuranceId, Insurance insurance) {
        return null;
    }

    public ResponseEntity<Void> deleteInsurance(int insuranceId) {
        return null;
    }
}
