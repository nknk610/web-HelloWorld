package com.example.demo.Protocol;

import com.example.demo.Domain.Comment;

import lombok.Data;

@Data
public class CommentUsernameProtocol extends Comment{
    private String userName;
    public CommentUsernameProtocol(Comment c, String username)
    {
        super(c);
        this.userName = username;
    }
}