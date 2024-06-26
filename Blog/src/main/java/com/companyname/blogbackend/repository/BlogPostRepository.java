package com.companyname.blogbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.companyname.blogbackend.entity.BlogPost;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
