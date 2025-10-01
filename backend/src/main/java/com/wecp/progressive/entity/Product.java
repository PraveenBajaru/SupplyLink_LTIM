package com.wecp.progressive.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productId;
private int warehouseId;
private String productName;
private String productDescription;
private int quantity;
private Long price;
@ManyToOne
private Warehouse warehouse;
public Product() {
}

public Product(int productId, int warehouseId, String productName, String productDescription, int quantity,
        Long price) {
    this.productId = productId;
    this.warehouseId = warehouseId;
    this.productName = productName;
    this.productDescription = productDescription;
    this.quantity = quantity;
    this.price = price;
}



public Product(Warehouse warehouse) {
    this.warehouse = warehouse;
}



public int getProductId() {
    return productId;
}

public void setProductId(int productId) {
    this.productId = productId;
}

public int getWarehouseId() {
    return warehouseId;
}

public void setWarehouseId(int warehouseId) {
    this.warehouseId = warehouseId;
}

public String getProductName() {
    return productName;
}

public void setProductName(String productName) {
    this.productName = productName;
}

public String getProductDescription() {
    return productDescription;
}

public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
}

public int getQuantity() {
    return quantity;
}

public void setQuantity(int quantity) {
    this.quantity = quantity;
}

public Long getPrice() {
    return price;
}

public void setPrice(Long price) {
    this.price = price;
}

public Warehouse getWarehouse() {
    return warehouse;
}

public void setWarehouse(Warehouse warehouse) {
    this.warehouse = warehouse;
}



}