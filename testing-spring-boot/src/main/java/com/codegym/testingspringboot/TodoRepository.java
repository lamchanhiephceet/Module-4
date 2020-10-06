package com.codegym.testingspringboot;

import java.util.List;

public interface TodoRepository {
    List<Todo> findAll();

    Todo findById(int id);
}
