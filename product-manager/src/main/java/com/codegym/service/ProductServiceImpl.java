package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

        private static Map<Integer, Product> products;

        static {

            products = new HashMap<>();
            products.put(1, new Product(1, "iPhone 11", "1000", "new","Apple"));
            products.put(2, new Product(2, "Macbook Air 13", "2500", "new","Apple"));
            products.put(3, new Product(3, "iPad 10", "1300", "new","Apple"));
        }

        @Override
        public List findAll() {
            return new ArrayList<>(products.values());
        }

        @Override
        public void save(Product product) {

            products.put(product.getId(), product);
        }

        @Override
        public Product findById(int id) {
            return products.get(id);
        }

        @Override
        public void update(int id, Product product) {
            products.put(id, product);

        }

        @Override
        public void remove(int id) {
            products.remove(id);
        }
}
