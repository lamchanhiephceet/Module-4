package com.example.demo.repository;



import com.example.demo.model.Post;

import java.util.List;

public interface PostRepository<T> {
    List<Post> findAll();

    Post findById(Long id);

//    void save(T model);

    void save(Post model);

    void remove(Long id);
}
