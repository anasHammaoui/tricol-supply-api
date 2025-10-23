package com.exemple.myapp.service;

import com.exemple.myapp.model.Supplier;
import com.exemple.myapp.repository.SupplierRepository;

import java.util.List;

public class SupplierServiceImpl implements SupplierService{


    private SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository){
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id);
    }

    @Override
    public void save(Supplier supplier) {
        supplierRepository.save(supplier);
    }

    @Override
    public void update(Long id, Supplier supplier) {
        Supplier existing = supplierRepository.findById(id);
        if (existing != null) {
            supplier.setId(id);
            supplierRepository.update(supplier);
        }
    }

    @Override
    public void delete(Long id) {
        supplierRepository.delete(id);
    }

    @Override
    public long count(){
        return supplierRepository.count();
    }

}