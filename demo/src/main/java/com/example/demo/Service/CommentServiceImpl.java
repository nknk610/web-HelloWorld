package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.Domain.Comment;
import com.example.demo.Domain.User;
import com.example.demo.Protocol.CommentUsernameProtocol;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService
{
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CommentUsernameProtocol add(Comment comment)
    {
        return new CommentUsernameProtocol(
            commentRepository.save(comment),
            userRepository.findById(comment.getUserId())
            .map(found -> found.getUsername())
            .orElse(null));
    }

    @Override
    public boolean delete(Long id)
    {
        try{
            commentRepository.deleteById(id);
            return true;
        } catch(Exception ex)
        {
            return false;
        }
    }

    @Override
    public CommentUsernameProtocol update(Long id, Comment comment)
    {
        Optional<User> user = userRepository.findById(comment.getUserId());
        if(user.isPresent())
        {
            return commentRepository.findById(id)
            .map(found->{
                found.setContent(Optional.ofNullable(comment.getContent()).orElse(found.getContent()));
                found.setStoredPath(Optional.ofNullable(comment.getStoredPath()).orElse(found.getStoredPath()));
                found.setOriginalName(Optional.ofNullable(comment.getOriginalName()).orElse(found.getOriginalName()));
                commentRepository.save(found);
                return new CommentUsernameProtocol(found, user.get().getUsername());
            }).orElse(null);
        }
        return null;
    }

    @Override
    public CommentUsernameProtocol view(Long id)
    {
        return commentRepository.findById(id)
        .map(found -> {
            Optional<User> user = userRepository.findById(found.getUserId());
            String username = user.isPresent() ? user.get().getUsername() : null;
            return new CommentUsernameProtocol(found, username);
        }).orElse(null);
    }

    @Override
    public List<CommentUsernameProtocol> list()
    {
        List<Comment> commentList = commentRepository.findAll();
        List<CommentUsernameProtocol> cupList = new ArrayList<>();
        commentList.forEach(comment->{
            Optional<User> found = userRepository.findById(comment.getUserId());
            String username = found.isPresent() ? found.get().getUsername() : null;
            cupList.add(new CommentUsernameProtocol(comment, username));
        });
        return cupList;
    }
}
