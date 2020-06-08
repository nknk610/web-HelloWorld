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

import kr.hs.dgsw.blog.Domain.User;
import kr.hs.dgsw.blog.Protocol.ResponseFormat;
import kr.hs.dgsw.blog.Protocol.ResponseType;
import kr.hs.dgsw.blog.Service.UserService;


//컨트롤러로 지정, UserService를 통한 기능들을 Mapping함
@RestController
public class UserController {
    //UserController 안에 UserService의 의존성을 Bean으로 구성
    @Autowired
    private UserService userService;

    //Post방식의 요청을 매핑, Request로 전달된 객체를 통해 User를 찾아 인자로 할당
    @PostMapping("/user/create")
    public ResponseFormat create(@RequestBody User user)
    {
        User newUser = userService.create(user);
        if(newUser != null)
        {
            return new ResponseFormat(
                ResponseType.USER_ADD,
                newUser,
                newUser.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    //Put방식의 요청을 매핑, id를 GET으로 받고 User의 정보는 Request에서 전달된 객체로 받음
    @PutMapping("user/update/{id}")
    public ResponseFormat update(@PathVariable long id, @RequestBody User user)
    {
        User updated = userService.update(id, user);
        if(updated != null)
        {
            return new ResponseFormat(
                ResponseType.USER_UPDATE,
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

    //Delete의 기능을 매핑, 유저의 id만 GET으로 받아서 처리
    @DeleteMapping("/user/delete/{id}")
    public ResponseFormat delete(@PathVariable long id)
    {
        boolean isSuccess = userService.delete(id);
        if(isSuccess)
        {
            return new ResponseFormat(
                ResponseType.USER_UPDATE,
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

    //단순한 GET방식의 처리, id값을 통해 유저를 탐색
    @GetMapping("/user/read/{id}")
    public ResponseFormat read(@PathVariable long id)
    {
        User user = userService.read(id);
        if(user != null)
        {
            return new ResponseFormat(
                ResponseType.USER_GET,
                user,
                user.getId()
            );
        }
        else{
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    //GET방식의 요청, 모든 user 리스트 반환
    @GetMapping("/user/read")
    public ResponseFormat readAll()
    {
        List<User> userList = userService.readAll();
        if(userList != null)
        {
            return new ResponseFormat(
                ResponseType.USER_GET,
                userList
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