package com.example.hanghaemarket.controller;

import com.example.hanghaemarket.dto.*;
import com.example.hanghaemarket.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("post")
@AllArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping
    public PostResponse createPost(
            @RequestBody PostCreateRequest request
    ) {
        return postService.createPost(request);
    }

    @GetMapping
    public List<PostReadResponse> readAllPost() {
        return postService.readAllPost();
    }

    @PutMapping("/{id}")
    public PostResponse UpdatePost(
            @PathVariable(name = "id") Long id,
            @RequestBody PostUpdateRequest request
    ) {
        return postService.updatePost(id, request);
    }

    @DeleteMapping("/{id}")
    public PostDeleteMessage deletePost(
            @PathVariable(name = "id") Long id
    ){
        postService.deletePost(id);
        return new PostDeleteMessage();
    }

}
