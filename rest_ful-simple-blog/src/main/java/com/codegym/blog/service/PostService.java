package com.codegym.blog.service;

import com.codegym.blog.model.Post;

import java.util.List;

public interface PostService {
        List<Post> findAll();

        Object findById(Long id);

        void save(Post post);

        void remove(Long id);
    }

