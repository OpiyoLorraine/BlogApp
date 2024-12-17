package com.example.blogapp.services;

import com.example.blogapp.models.dtos.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
