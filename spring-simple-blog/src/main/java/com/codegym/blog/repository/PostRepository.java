package com.codegym.blog.repository;

import com.codegym.blog.model.Post;
import com.codegym.blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> findAllByCategory(Category category);
    Page<Post> findAllByTitleContaining(String title, Pageable pageable);
}
