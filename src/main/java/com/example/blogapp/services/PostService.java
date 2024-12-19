package com.example.blogapp.services;

import com.example.blogapp.models.dtos.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts();

    PostDto getPostById(long id);
}
