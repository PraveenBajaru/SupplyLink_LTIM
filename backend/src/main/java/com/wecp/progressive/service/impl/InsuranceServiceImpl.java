package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Insurance;
import com.wecp.progressive.repository.InsuranceRepository;
import com.wecp.progressive.service.InsuranceService;

@Service
public class InsuranceServiceImpl  implements InsuranceService{

    @Autowired
    InsuranceRepository insuranceRepository;

    @Override
    public int addInsurance(Insurance insurance) {
        insuranceRepository.save(insurance);
        return insurance.getInsuranceId();
    }

    @Override
    public void deleteInsurance(int insuranceId) {
        insuranceRepository.deleteByInsuranceId(insuranceId);
    }

    @Override
    public List<Insurance> getAllInsurances() throws SQLException{
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance getInsuranceById(int insuranceId) throws SQLException{
        return insuranceRepository.findByInsuranceId(insuranceId);
    }

    @Override
    public void updateInsurance(Insurance insurance) {
        // TODO Auto-generated method stub
        
    }

    
}