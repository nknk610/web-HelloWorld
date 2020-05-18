package com.example.demo.Controller;

import java.util.List;

import com.example.demo.Domain.Comment;
import com.example.demo.Protocol.CommentUsernameProtocol;
import com.example.demo.Service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")
    public CommentUsernameProtocol add(@RequestBody Comment user)
    {
        return commentService.add(user);
    }

    @PutMapping("/comment/update/{id}")
    public CommentUsernameProtocol update(@PathVariable Long id, @RequestBody Comment user)
    {
        return commentService.update(id, user);
    }

    @DeleteMapping("/comment/delete/{id}")
    public boolean delete(@PathVariable Long id)
    {
        return commentService.delete(id);
    }

    @GetMapping("/comment/view/{id}")
    public CommentUsernameProtocol view(@PathVariable Long id)
    {
        return commentService.view(id);
    }

    @GetMapping("/comment/list")
    public List<CommentUsernameProtocol> list()
    {
        return commentService.list();
    }
}