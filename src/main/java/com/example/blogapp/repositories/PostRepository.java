package com.example.blogapp.repositories;

import com.example.blogapp.models.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    //no need to write code here because JpaRepository writes for us all the CRUD methods
    //we also don't need @Repository because JpaRepository has SimpleRepository class that comes with the annotation
}
