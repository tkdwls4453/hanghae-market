package com.example.hanghaemarket.service;

import com.example.hanghaemarket.domain.Post;
import com.example.hanghaemarket.dto.PostCreateRequest;
import com.example.hanghaemarket.dto.PostResponse;
import com.example.hanghaemarket.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostServiceTest {

    @Autowired
    private PostService sut;

    @Autowired
    private PostRepository postRepository;

    @AfterEach
    void tearDown() {
        postRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("게시물을 성공적으로 생성시, 생성된 게시물 정보를 반환한다.")
    void createPost(){
        // Given
        PostCreateRequest request = PostCreateRequest.builder()
                .username("한효승")
                .title("노트북 팝니다~!")
                .content("이제 안쓰는 노트북을 처분하려고 해요.")
                .price(150000)
                .build();

        // When
        PostResponse result = sut.createPost(request);

        // Then
        assertThat(result)
                .extracting("id", "username", "title", "content", "price")
                .containsExactly(1L, "한효승", "노트북 팝니다~!", "이제 안쓰는 노트북을 처분하려고 해요.", 150000);

        List<Post> postList = postRepository.findAll();
        assertThat(postList).hasSize(1);
        assertThat(postList.get(0))
                .extracting("id", "username", "title", "content", "price")
                .containsExactly(1L, "한효승", "노트북 팝니다~!", "이제 안쓰는 노트북을 처분하려고 해요.", 150000);
    }
}