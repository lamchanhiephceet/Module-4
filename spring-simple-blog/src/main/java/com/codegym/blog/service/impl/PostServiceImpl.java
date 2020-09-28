package com.codegym.blog.service.impl;

import com.codegym.blog.model.Post;
import com.codegym.blog.model.Category;
import com.codegym.blog.repository.PostRepository;
import com.codegym.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        postRepository.delete(id);
    }

    @Override
    public Iterable<Post> findAllByCategory(Category category) {
        return postRepository.findAllByCategory(category);
    }
    @Override
    public Page<Post> findAllByTitleContaining(String title, Pageable pageable) {
        return postRepository.findAllByTitleContaining(title, pageable);
    }

}
