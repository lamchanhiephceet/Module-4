package com.customer.service.customer;

public interface IService<T> {
    Iterable<T> findAll();

    T findById(Integer id);

    void update(T model);

    void save(T model);

    void remove(Long id);
}
