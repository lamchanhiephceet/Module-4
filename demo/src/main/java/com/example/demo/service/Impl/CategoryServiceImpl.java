package com.example.demo.service.Impl;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

        @Autowired
        private CategoryRepository categoryRepository;

        @Override
        public List<Category> findAll() {
            return categoryRepository.findAll();
        }

        @Override
        public Object findById(Long id) {
            return categoryRepository.findById(id);
        }

        @Override
        public void save(Category category) {
            categoryRepository.save(category);
        }

        @Override
        public void remove(Long id) {
            categoryRepository.remove(id);
        }
    }
