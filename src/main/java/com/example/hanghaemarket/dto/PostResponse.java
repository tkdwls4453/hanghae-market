package com.example.hanghaemarket.dto;

import com.example.hanghaemarket.domain.Post;
import lombok.Builder;
import lombok.Data;

@Data
public class PostResponse {
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    @Builder
    private PostResponse(Long id, String username, String title, String content, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public static PostResponse from(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .username(post.getUsername())
                .title(post.getTitle())
                .content(post.getContent())
                .price(post.getPrice())
                .build();
    }

}
