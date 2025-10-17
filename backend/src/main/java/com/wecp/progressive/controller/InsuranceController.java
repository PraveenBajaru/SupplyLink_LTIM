package com.wecp.progressive.controller;

import com.wecp.progressive.entity.Insurance;
import com.wecp.progressive.service.impl.InsuranceServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {


    @Autowired
    private InsuranceServiceImpl insuranceServiceImpl;

    @GetMapping
    public ResponseEntity<List<Insurance>> getAllInsurances() {

        try{
            return new ResponseEntity<>(insuranceServiceImpl.getAllInsurances() , HttpStatus.OK);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{insuranceId}")
    public ResponseEntity<Insurance> getInsuranceById(@PathVariable int insuranceId) {
        try{
            if(insuranceServiceImpl.getInsuranceById(insuranceId)!=null){
            return new ResponseEntity<>(insuranceServiceImpl.getInsuranceById(insuranceId) , HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<Integer> createInsurance(@RequestBody Insurance insurance) {
        try{
            insuranceServiceImpl.addInsurance(insurance); 
            return new ResponseEntity<>(insurance.getInsuranceId() , HttpStatus.CREATED);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{insuranceId}")
    public ResponseEntity<Void> updateInsurance(@PathVariable int insuranceId, @RequestBody Insurance insurance) {

        try{
            insuranceServiceImpl.updateInsurance(insurance); 
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{insuranceId}")
    public ResponseEntity<Void> deleteInsurance(@PathVariable int insuranceId) {
        try{
            insuranceServiceImpl.deleteInsurance(insuranceId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(SQLException se){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
