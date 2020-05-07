package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//UserServiceImpl의 함수들을 각각 호출
@RestController
public class UserController {
    @Autowired
    UserService userService;

    //Get 방식을 User정보를 얻어오는 함수로 연결
    @GetMapping("/user")
    @ResponseBody
    public List<User> list()
    {
        return userService.list();
    }

    //id를 지정할 시에 id가 일치하는 값만 탐색
    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id)
    {
        return userService.view(id);
    }

    //Post방식으로 보낸 값을 UserList에 저장
    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user)
    {
        return userService.add(user);
    }

    //Put 방식으로 받은 값의 id와 일치하는 User 정보를 변경
    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user)
    {
        return userService.update(user);
    }

    //id와 일치하는 User 정보 삭제
    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id)
    {
        return userService.delete(id);
    }
}