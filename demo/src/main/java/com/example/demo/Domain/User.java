package com.example.demo.Domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


//User 정보를 담는 클래스
//@Getter //각 변수의 Getter함수를 알려주기 위한 Annotation
//@Setter //각 변수의 Setter함수를 알려주기 위한 Annotation
//@ToString //ToString 함수를 자동 생성해주는 Annotation
@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime joind;
    @UpdateTimestamp
    private LocalDateTime modified;
    private String storedPath;
    private String originalName;

    public User(final String name, final String email, final String password, final String storedPath, final String originalName)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.storedPath = storedPath;
        this.originalName = originalName;
    }

    
}