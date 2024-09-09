package com.example.hanghaemarket.repository;

import com.example.hanghaemarket.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
