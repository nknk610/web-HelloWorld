package com.example.demo;


import javax.persistence.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//User 정보를 담는 클래스
//@Getter //각 변수의 Getter함수를 알려주기 위한 Annotation
//@Setter //각 변수의 Setter함수를 알려주기 위한 Annotation
//@ToString //ToString 함수를 자동 생성해주는 Annotation
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String name;
    private String email;
}