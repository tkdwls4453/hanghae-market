package com.example.hanghaemarket.service;

import com.example.hanghaemarket.domain.Post;
import com.example.hanghaemarket.dto.PostCreateRequest;
import com.example.hanghaemarket.dto.PostReadResponse;
import com.example.hanghaemarket.dto.PostResponse;
import com.example.hanghaemarket.dto.PostUpdateRequest;
import com.example.hanghaemarket.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@AllArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;


    public PostResponse createPost(PostCreateRequest request) {
        Post post = request.toEntity();
        Post savedPost = postRepository.save(post);

        return PostResponse.from(savedPost);
    }

    @Transactional(readOnly = true)
    public List<PostReadResponse> readAllPost() {
        return postRepository.findAll().stream()
                .map(PostReadResponse::from)
                .collect(Collectors.toList());
    }

    public PostResponse updatePost(Long id, PostUpdateRequest request) {
        Post foundPost = postRepository.findById(id).orElseThrow(
                () -> {
                    throw new IllegalArgumentException("존재하지 않는 게시물 ID 입니다.");
                }
        );

        foundPost.changeInfo(request);
        return PostResponse.from(foundPost);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
