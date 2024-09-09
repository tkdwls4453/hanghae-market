package com.example.hanghaemarket.dto;

import lombok.Data;

@Data
public class PostUpdateRequest {
    private String username;
    private String content;
    private String title;
    private int price;


}
