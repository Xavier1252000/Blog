package com.myblog.blogapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String body;
    @Column(unique = true)
    private String email;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)  //it is liked to post by one to many relation but since we are definging it here so many to one annotation is used.
    @JoinColumn(name="post_id",nullable = false)
    private Post post;  //LAZY means entity will we loded when required.
}
