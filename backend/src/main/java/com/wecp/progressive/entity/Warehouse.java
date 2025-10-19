package com.wecp.progressive.entity;

import java.util.Comparator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Warehouse implements Comparable<Warehouse>{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int warehouseId;
private int supplierId;
private String warehouseName;
private String location;
private int capacity;

@ManyToOne
private Supplier supplier;

public Warehouse() {
}
public Warehouse(int warehouseId, int supplierId, String warehouseName, String location, int capacity) {
    this.warehouseId = warehouseId;
    this.supplierId = supplierId;
    this.warehouseName = warehouseName;
    this.location = location;
    this.capacity = capacity;
}
public int getWarehouseId() {
    return warehouseId;
}
public void setWarehouseId(int warehouseId) {
    this.warehouseId = warehouseId;
}
public int getSupplierId() {
    return supplierId;
}
public void setSupplierId(int supplierId) {
    this.supplierId = supplierId;
}
public String getWarehouseName() {
    return warehouseName;
}
public void setWarehouseName(String warehouseName) {
    this.warehouseName = warehouseName;
}
public String getLocation() {
    return location;
}
public void setLocation(String location) {
    this.location = location;
}
public int getCapacity() {
    return capacity;
}
public void setCapacity(int capacity) {
    this.capacity = capacity;
}
@Override
public int compareTo(Warehouse o) {
    return Integer.compare(o.capacity, this.capacity);
}

public Supplier getSupplier() {
    return supplier;
}
public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
}
public Warehouse(Supplier supplier) {
    this.supplier = supplier;
}



}