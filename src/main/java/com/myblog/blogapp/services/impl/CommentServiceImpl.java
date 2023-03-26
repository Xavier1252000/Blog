package com.myblog.blogapp.services.impl;

import com.myblog.blogapp.entities.Comment;
import com.myblog.blogapp.entities.Post;
import com.myblog.blogapp.exceptions.ResourceNotFoundException;
import com.myblog.blogapp.payload.CommentDto;
import com.myblog.blogapp.repository.CommentRepository;
import com.myblog.blogapp.repository.PostRepository;
import com.myblog.blogapp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepo;

    @Autowired
    private PostRepository postRepo;

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post", "id", postId)
        );
        Comment comment = mapToComment(commentDto);
        comment.setPost(post);
        Comment newComment = commentRepo.save(comment);
        CommentDto dto = mapToDto(newComment);

        return dto;
    }

    @Override
    public List<CommentDto> getCommnetByPostId(long postId) {
        List<Comment> comments = commentRepo.findByPostId(postId);
        return comments.stream().map(comment -> mapToDto(comment)).collect(Collectors.toList());
    }

    @Override
    public CommentDto deletePostByID(long postId, long id) {
        Post post = postRepo.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("post id", "id", id)
        );
        Optional<Comment> byId = commentRepo.findById(id);
        if (byId==null){
            new ResourceNotFoundException("Comment","id", id);
        }
        Comment comment = byId.get();
        CommentDto dto = mapToDto(comment);

        commentRepo.deleteById(id);
        return dto;
    }

    Comment mapToComment(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }

    CommentDto mapToDto(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }
}
