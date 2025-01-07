package com.example.blogapp.services;

import com.example.blogapp.models.dtos.PostDto;
import com.example.blogapp.models.dtos.PostResponse;


import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
