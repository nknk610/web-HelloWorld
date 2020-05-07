package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


//User 정보를 담는 클래스
@Getter //각 변수의 Getter함수를 알려주기 위한 Annotation
@Setter //각 변수의 Setter함수를 알려주기 위한 Annotation
@ToString //ToString 함수를 자동 생성해주는 Annotation
public class User {
    private String id;
    private String name;
    private String email;

    public User(){}

    public User(String id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}