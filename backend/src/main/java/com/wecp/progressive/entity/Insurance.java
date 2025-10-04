package com.wecp.progressive.entity;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int insuranceId;

    @ManyToOne
    @JoinColumn(name = "shipmentId")
    private Shipment shipment;

    private String insuranceProvider;

    private Long insuranceCoverageAmount;

    public Insurance(){}

    public Insurance(Shipment shipment, String insuranceProvider, Long insuranceCoverageAmount) {
        this.shipment = shipment;
        this.insuranceProvider = insuranceProvider;
        this.insuranceCoverageAmount = insuranceCoverageAmount;
    }

    

    public Insurance(int insuranceId, Shipment shipment, String insuranceProvider, Long insuranceCoverageAmount) {
        this.insuranceId = insuranceId;
        this.shipment = shipment;
        this.insuranceProvider = insuranceProvider;
        this.insuranceCoverageAmount = insuranceCoverageAmount;
    }

    public Insurance(String insuranceProvider, Long insuranceCoverageAmount) {
        this.insuranceProvider = insuranceProvider;
        this.insuranceCoverageAmount = insuranceCoverageAmount;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public Long getInsuranceCoverageAmount() {
        return insuranceCoverageAmount;
    }

    public void setInsuranceCoverageAmount(Long insuranceCoverageAmount) {
        this.insuranceCoverageAmount = insuranceCoverageAmount;
    }

    

}