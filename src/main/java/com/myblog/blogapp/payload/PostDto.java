package com.myblog.blogapp.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PostDto {
    private long id;
    @NotEmpty(message = "Title is mandatory")
    @Size(min = 2, max = 25)
    private String title;
    private String description;
    @Size(min = 1, max = 5000)
    private String content;
}
