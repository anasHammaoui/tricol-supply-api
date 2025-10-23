package com.exemple.myapp.controller;

import com.exemple.myapp.service.impl.SupplierService;

public class SupplierController {
    private SupplierService supplierService;
    public SupplierController(){}
    public SupplierController(SupplierService supplierService){
        this.supplierService = supplierService;
    }
}
