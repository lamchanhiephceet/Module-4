package com.customer.service.customer;

import com.customer.config.AppConfiguration;
import com.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class CustomerService implements ICustomerService {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Iterable findAll() {
        String queryStr = "SELECT c FROM Customer AS c";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        return query.getResultList();
    }

    @Override
    public Object findById(Integer id) {
        String queryStr = "SELECT c FROM Customer AS c WHERE c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(queryStr, Customer.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void update(Object model) {

    }

    @Override
    public void save(Object model) {

    }

    @Override
    public void remove(Long id) {

    }
}
