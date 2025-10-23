package com.exemple.myapp.service.impl;

import com.exemple.myapp.repository.impl.SupplierRepository;
import com.exemple.myapp.service.SupplierServiceInterface;

public class SupplierService implements SupplierServiceInterface {
    private SupplierRepository supplierRepository;
    public SupplierService(SupplierRepository supplierRepository){
        this.supplierRepository=supplierRepository;
    }
}
