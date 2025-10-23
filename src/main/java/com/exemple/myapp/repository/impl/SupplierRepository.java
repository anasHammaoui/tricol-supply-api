package com.exemple.myapp.repository.impl;

import com.exemple.myapp.repository.SupplierRepositoryInterface;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

public class SupplierRepository implements SupplierRepositoryInterface {

    private EntityManagerFactory entityManagerFactory;

    public SupplierRepository(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean){
        this.entityManagerFactory = entityManagerFactoryBean.getObject();
    }

}
