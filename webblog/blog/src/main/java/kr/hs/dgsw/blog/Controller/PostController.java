package kr.hs.dgsw.blog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.blog.Domain.Post;
import kr.hs.dgsw.blog.Protocol.ResponseFormat;
import kr.hs.dgsw.blog.Protocol.ResponseType;
import kr.hs.dgsw.blog.Service.PostService;

//컨트롤러로 지정, PostService를 통한 기능들을 Mapping함
@RestController
public class PostController {
    //PostController 안에 PostService의 의존성을 Bean으로 구성
    @Autowired
    private PostService postService;

    //Post방식의 요청을 매핑, Request로 전달된 객체를 통해 Post를 찾아 인자로 할당
    @PostMapping("/post/create")
    public ResponseFormat create(@RequestBody Post post)
    {
        Post newPost = postService.create(post);
        if(newPost != null)
        {
            return new ResponseFormat(
                ResponseType.POST_ADD,
                newPost,
                newPost.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    //Put방식의 요청을 매핑, id를 GET으로 받고 Post의 정보는 Request에서 전달된 객체로 받음
    @PutMapping("post/update/{id}")
    public ResponseFormat update(@PathVariable long id, @RequestBody Post post)
    {
        Post updated = postService.update(id, post);
        if(updated != null)
        {
            return new ResponseFormat(
                ResponseType.POST_UPDATE,
                updated,
                updated.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    //Delete의 기능을 매핑, 게시물의 id만 GET으로 받아서 처리
    @DeleteMapping("/post/delete/{id}")
    public ResponseFormat delete(@PathVariable long id)
    {
        boolean isSuccess = postService.delete(id);
        if(isSuccess)
        {
            return new ResponseFormat(
                ResponseType.POST_UPDATE,
                isSuccess,
                id
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    //단순한 GET방식의 처리, id값을 통해 게시물을 탐색
    @GetMapping("/post/read/{id}")
    public ResponseFormat read(@PathVariable long id)
    {
        Post post = postService.read(id);
        if(post != null)
        {
            return new ResponseFormat(
                ResponseType.POST_GET,
                post,
                post.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    //GET방식의 요청, 유저Id에 맞는 게시물 리스트 중 하나를 반환
    @GetMapping("/post/read/user/{userId}")
    public ResponseFormat readByUserId(@PathVariable long userId)
    {
        Post post = postService.readByUserId(userId);
        if(post != null)
        {
            return new ResponseFormat(
                ResponseType.POST_GET_BY_USER,
                post,
                post.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    //GET방식의 요청, 모든 게시물을 가져옴
    @GetMapping("/post/read")
    public ResponseFormat readAll()
    {
        List<Post> postList = postService.readAll();
        if(postList != null)
        {
            return new ResponseFormat(
                ResponseType.POST_GET_ALL,
                postList
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }
}