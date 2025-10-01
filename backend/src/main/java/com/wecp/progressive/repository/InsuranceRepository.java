package com.wecp.progressive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wecp.progressive.entity.Insurance;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long>{
    Insurance findByInsuranceId(int insuranceID);
    void deleteByInsuranceId(int insuranceID);
}
