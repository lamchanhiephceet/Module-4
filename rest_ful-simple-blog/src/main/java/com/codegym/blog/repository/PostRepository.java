package com.codegym.blog.repository;

import com.codegym.blog.model.Post;

import java.util.List;

public interface PostRepository<T> {
    List<Post> findAll();

    T findById(Long id);

//    void save(T model);

    void save(Post model);

    void remove(Long id);
}
