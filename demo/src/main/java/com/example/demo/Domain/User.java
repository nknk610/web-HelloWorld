package com.example.demo.Domain;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Entity;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String username;
    private String email;
    private String password;
    @CreationTimestamp
    private LocalDateTime joined;
    @UpdateTimestamp
    private LocalDateTime modified;
    private String storedPath;
    private String originalName;

    public User(final String name, final String email, final String password, final String storedPath, final String originalName)
    {
        this.username = name;
        this.email = email;
        this.password = password;
        this.storedPath = storedPath;
        this.originalName = originalName;
    }
}