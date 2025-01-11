package com.example.blogapp.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String body; //i.e. message body or content

    @ManyToOne(fetch = FetchType.LAZY)//type lazy tells hibernate to fetch only related entities from the db
    @JoinColumn(name = "post_id", nullable = false)//shows foreign key in a database
    private Post post;
}
