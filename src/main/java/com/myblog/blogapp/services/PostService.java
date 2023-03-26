package com.myblog.blogapp.services;

import com.myblog.blogapp.payload.PostDto;
import com.myblog.blogapp.payload.PostResponse;
import javafx.geometry.Pos;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePost(long id);
}
