package com.exemple.myapp.repository;


import com.exemple.myapp.model.Supplier;

import java.util.List;

public interface SupplierRepository{
    List<Supplier> findAll();
    Supplier findById(Long id);
    void save(Supplier supplier);
    void update(Supplier supplier);
    void delete(Long id);
    long count();
}