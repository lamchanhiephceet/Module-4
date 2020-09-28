package com.codegym.blog.service.impl;

import com.codegym.blog.model.Post;
import com.codegym.blog.repository.PostRepository;
import com.codegym.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Object findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.remove(id);
    }
}

