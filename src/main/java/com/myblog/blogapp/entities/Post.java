package com.myblog.blogapp.entities;
import lombok.*;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title", nullable = false, unique = true)
    private String title;

    @Column(name="description", nullable = false)
    private String description;

    @Lob
    @Column(name="content", nullable = false)
    private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)//bidirectional mapping-mapped from both the entity classes
    Set<Comment> comments = new HashSet<>() ;
}
