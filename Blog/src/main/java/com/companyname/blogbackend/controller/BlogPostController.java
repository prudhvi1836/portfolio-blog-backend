package com.companyname.blogbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.companyname.blogbackend.entity.BlogPost;
import com.companyname.blogbackend.repository.BlogPostRepository;
import com.companyname.blogbackend.util.BlogNotFoundException;

@RestController
@RequestMapping("/api/posts")
public class BlogPostController{

    @Autowired
    private BlogPostRepository blogPostRepository;

    @PostMapping
    public BlogPost createPost(@RequestBody BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }
    @GetMapping("/getAllBlogContent")
    public List<BlogPost> getAllPosts() {
        return blogPostRepository.findAll();
    }
    @GetMapping("/getBlog/{id}")
    public BlogPost getBlog(@PathVariable Long id) {
        return blogPostRepository.findById(id).orElseThrow(() -> new BlogNotFoundException(id));
    }
}