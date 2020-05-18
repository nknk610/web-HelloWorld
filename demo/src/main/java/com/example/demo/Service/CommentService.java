package com.example.demo.Service;

import java.util.List;

import com.example.demo.Domain.Comment;
import com.example.demo.Protocol.CommentUsernameProtocol;

public interface CommentService {
    CommentUsernameProtocol add(Comment comment);
    CommentUsernameProtocol update(Long id, Comment comment);
    boolean delete(Long id);
    CommentUsernameProtocol view(Long id);
    List<CommentUsernameProtocol> list();
}