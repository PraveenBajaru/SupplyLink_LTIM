package com.wecp.progressive.exception;

public class NoWarehouseFoundForSupplierException extends RuntimeException{
    public NoWarehouseFoundForSupplierException(String msg) {
        super(msg);
    }
}