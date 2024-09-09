package com.example.hanghaemarket.dto;

import com.example.hanghaemarket.domain.Post;
import lombok.Builder;
import lombok.Data;

@Data
public class PostCreateRequest {
    private String username;

    private String content;
    private String title;
    private int price;

    @Builder
    private PostCreateRequest(String username, String content, String title, int price) {
        this.username = username;
        this.content = content;
        this.title = title;
        this.price = price;
    }

    public Post toEntity() {
        return Post.builder()
                .username(this.username)
                .title(this.title)
                .content(this.content)
                .price(this.price)
                .build();
    }
}
