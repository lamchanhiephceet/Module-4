package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;


    @RequestMapping(value = "/posts/", method = RequestMethod.GET)
    public ResponseEntity<List<Post>> listAllPosts() {
        List<Post> posts = postService.findAll();
        if (posts.isEmpty()) {
            return new ResponseEntity<List<Post>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }


    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> getPost(@PathVariable("id") long id) {
        System.out.println("Fetching Post with id " + id);
        Post post = (Post) postService.findById(id);
        if (post == null) {
            System.out.println("Post with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }


    @RequestMapping(value = "/posts/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPost(@RequestBody Post post, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Post " + post.getTitle());
        postService.save(post);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/posts/{id}").buildAndExpand(post.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }



    @RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Post> updatePost(@PathVariable("id") long id, @RequestBody Post post) {
        System.out.println("Updating Post " + id);

        Post currentPost = (Post) postService.findById(id);

        if (currentPost == null) {
            System.out.println("Post with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }

        currentPost.setTitle(post.getTitle());
        currentPost.setBody(post.getBody());
        currentPost.setAuthor(post.getAuthor());
        currentPost.setDate(post.getDate());
        currentPost.setId(post.getId());

        postService.save(currentPost);
        return new ResponseEntity<Post>(currentPost, HttpStatus.OK);
    }



    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Post> deletePost(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Post with id " + id);

        Post post = (Post) postService.findById(id);
        if (post == null) {
            System.out.println("Unable to delete. Post with id " + id + " not found");
            return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
        }

        postService.remove(id);
        return new ResponseEntity<Post>(HttpStatus.NO_CONTENT);
    }
}