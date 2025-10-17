package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Insurance;
import com.wecp.progressive.repository.InsuranceRepository;

@Service
public class InsuranceServiceImpl  {

    @Autowired
    private InsuranceRepository insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    public List<Insurance> getAllInsurances()throws SQLException{

        return insuranceRepository.findAll();

    }

    public int addInsurance(Insurance insurance)throws SQLException{

        insuranceRepository.save(insurance);
        return insurance.getInsuranceId();
    
    }

    public Insurance getInsuranceById(int insuranceId)throws SQLException{

        return insuranceRepository.findByInsuranceId(insuranceId);

    }

    public void updateInsurance(Insurance insurance)throws SQLException{

        if(insurance!=null){

            Insurance Existinginsurance = insuranceRepository.findByInsuranceId(insurance.getInsuranceId());
            
            Existinginsurance.setInsuranceCoverageAmount(insurance.getInsuranceCoverageAmount());
            Existinginsurance.setInsuranceProvider(insurance.getInsuranceProvider());
            Existinginsurance.setShipment(insurance.getShipment());
            insuranceRepository.save(Existinginsurance);

        }

    }

    public void deleteInsurance(int insuranceId)throws SQLException{

        insuranceRepository.deleteById(insuranceId);

    }


}