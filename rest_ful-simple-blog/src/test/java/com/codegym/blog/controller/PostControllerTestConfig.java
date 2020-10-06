package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.service.CategoryService;
import com.codegym.blog.service.PostService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@ComponentScan("com.codegym.blog")
public class CustomerControllerTestConfig {


    @Bean
    public PostService postService() {
        return Mockito.mock(PostServiceImplWithSpringData.class);
    }
    @Bean
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("blog")
                .build();
    }

    @Bean
    public CategoryService categoryService() {
        return Mockito.mock(CategoryServiceImplWithSpringData.class);
    }
}