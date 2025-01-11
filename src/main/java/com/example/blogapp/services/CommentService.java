package com.example.blogapp.services;

import com.example.blogapp.models.dtos.CommentDto;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);
}
