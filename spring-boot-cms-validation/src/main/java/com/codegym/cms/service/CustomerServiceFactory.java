package com.codegym.cms.service;

import com.codegym.cms.service.impl.SimpleCustomerServiceImpl;



public class CustomerServiceFactory {
    private static CustomerService singleton;

    public static synchronized CustomerService getInstance() {
        if (singleton == null) {
            singleton = new SimpleCustomerServiceImpl();
        }
        return singleton;
    }
}
