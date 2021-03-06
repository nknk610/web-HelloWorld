package kr.hs.dgsw.blog.Service;

import java.util.List;

import kr.hs.dgsw.blog.Domain.Post;

public interface PostService {
    Post create(Post post);
    Post read(Long id);
    Post readByUserId(Long userId);
    Post update(Long id, Post post);
    boolean delete(Long id);
    List<Post> readAll();
}