package com.example.blogapp.services.impl;

import com.example.blogapp.models.dtos.PostDto;
import com.example.blogapp.models.entities.Post;
import com.example.blogapp.repositories.PostRepository;
import com.example.blogapp.services.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        //convert DTO to entity
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        Post newpost = postRepository.save(post);

        //convert entity to DTO
        PostDto postResponse = new PostDto();
        postResponse.setId(newpost.getId());
        postResponse.setTitle(newpost.getTitle());
        postResponse.setDescription(newpost.getDescription());
        postResponse.setContent(newpost.getContent());

        return postResponse;
    }
}
