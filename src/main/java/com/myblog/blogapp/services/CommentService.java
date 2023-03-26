package com.myblog.blogapp.services;

import com.myblog.blogapp.payload.CommentDto;

import java.util.List;

public interface CommentService {
    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommnetByPostId(long postId);

    CommentDto deletePostByID(long postId, long id);
}