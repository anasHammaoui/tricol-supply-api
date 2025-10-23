package com.exemple.myapp.service;


import com.exemple.myapp.model.Supplier;

import java.util.List;

public interface SupplierService {
    List<Supplier> findAll();
    Supplier findById(Long id);
    void save(Supplier supplier);
    void update(Long id, Supplier supplier);
    void delete(Long id);
    long count();
}