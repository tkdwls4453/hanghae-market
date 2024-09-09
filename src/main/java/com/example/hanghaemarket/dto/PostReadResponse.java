package com.example.hanghaemarket.dto;

import com.example.hanghaemarket.domain.Post;
import lombok.Builder;
import lombok.Data;

@Data
public class PostReadResponse {
    private Long id;
    private String title;
    private String username;
    private int price;

    @Builder
    private PostReadResponse(Long id, String username, String title, int price) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.price = price;
    }

    public static PostReadResponse from(Post post) {
        return PostReadResponse.builder()
                .id(post.getId())
                .username(post.getUsername())
                .title(post.getTitle())
                .price(post.getPrice())
                .build();
    }

}
