package com.myblog.blogapp.controller;

import com.myblog.blogapp.payload.CommentDto;
import com.myblog.blogapp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@Valid @PathVariable("postId") long postId, @RequestBody CommentDto commentDto){
        CommentDto dto = commentService.createComment(postId,commentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("posts/{postId}/comments")
    public List<CommentDto> getAllCommentsByPostId(@PathVariable("postId") long postId){
        List<CommentDto> dto = commentService.getCommnetByPostId(postId);
        return dto;
    }

    @DeleteMapping("posts/{postId}/comments/{id}")
    public ResponseEntity<CommentDto> deleteCommentById(@PathVariable("postId") long postId, @PathVariable("id") long id){
        CommentDto dto = commentService.deletePostByID(postId, id);
        return new ResponseEntity<>(dto, HttpStatus.OK) ;
    }
}
