package com.codegym.blog.controller;

import com.codegym.blog.model.Post;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.PostService;
import com.codegym.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

//    @GetMapping("/customers")
//    public ModelAndView listCustomers(Pageable pageable){
////        Iterable<Customer> customers = customerService.findAll();
//        Page<Customer> customers = customerService.findAll(pageable);
//        ModelAndView modelAndView = new ModelAndView("/customer/list");
//        modelAndView.addObject("customers", customers);
//        return modelAndView;
//    }
@GetMapping("/posts")
public ModelAndView listCustomers(@RequestParam("s") Optional<String> s, Pageable pageable){
    Page<Post> posts;
    if(s.isPresent()){
        posts = postService.findAllByTitleContaining(s.get(), pageable);
    } else {
        posts = postService.findAll(pageable);
    }
    ModelAndView modelAndView = new ModelAndView("/post/layout");
    modelAndView.addObject("posts", posts);
    return modelAndView;
}

    @GetMapping("/create-post")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        return modelAndView;
    }

    @PostMapping("/create-post")
    public ModelAndView saveCustomer(@ModelAttribute("post") Post post){
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/create");
        modelAndView.addObject("post", new Post());
        modelAndView.addObject("message", "New post created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-post/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/edit");
            modelAndView.addObject("post", post);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-post")
    public ModelAndView updateCustomer(@ModelAttribute("post") Post post){
        postService.save(post);
        ModelAndView modelAndView = new ModelAndView("/post/edit");
        modelAndView.addObject("post", post);
        modelAndView.addObject("message", "Post updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-post/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Post post = postService.findById(id);
        if(post != null) {
            ModelAndView modelAndView = new ModelAndView("/post/delete");
            modelAndView.addObject("post", post);
            return modelAndView;

        }else {
            ModelAndView modelAndView = new ModelAndView("/error/404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-post")
    public String deletePost(@ModelAttribute("post") Post post){
        postService.remove(post.getId());
        return "redirect:posts";
    }
}
