package com.example.hanghaemarket.domain;

import com.example.hanghaemarket.dto.PostUpdateRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String title;

    private String content;

    private int price;

    @Builder
    private Post(String username, String title, String content, int price) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.price = price;
    }

    public void changeInfo(PostUpdateRequest request) {
        this.username = request.getUsername();
        this.title = request.getTitle();
        this.content = request.getContent();
        this.price = request.getPrice();
    }
}
