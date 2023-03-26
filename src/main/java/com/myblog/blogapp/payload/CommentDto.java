package com.myblog.blogapp.payload;

import lombok.Data;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.Column;

@Data
public class CommentDto {
    private long id;
    private String body;
    @Column(unique = true)
    private String email;
    private String name;
}
