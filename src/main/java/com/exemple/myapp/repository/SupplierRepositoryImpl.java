package com.exemple.myapp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import com.exemple.myapp.model.Supplier;

import java.util.List;

public class SupplierRepositoryImpl implements SupplierRepository{
    private EntityManagerFactory entityManagerFactory;

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public List<Supplier> findAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        List<Supplier> suppliers = em.createQuery("from Supplier", Supplier.class).getResultList();
        em.close();
        return suppliers;
    }

    @Override
    public Supplier findById(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        Supplier s = em.find(Supplier.class, id);
        em.close();
        return s;
    }

    @Override
    public void save(Supplier supplier) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(supplier);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Supplier supplier) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(supplier);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Supplier s = em.find(Supplier.class, id);
        if (s != null) em.remove(s);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public long count() {
        EntityManager em = entityManagerFactory.createEntityManager();
        return em.createQuery("SELECT COUNT(s) FROM Supplier s", Long.class).getSingleResult();
    }
}