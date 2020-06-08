package kr.hs.dgsw.blog.Domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //클래스를 Entity로 지정
@Data //변수들의 Getter, Setter과 클래스의 ToString 자동 생성
@NoArgsConstructor //인자가 없는 생성자를 생성
public class Post {
    @Id //테이블에서 Id로 사용
    @GeneratedValue(strategy=GenerationType.IDENTITY) //mysql방식에 의해 autoIncreasement로 지정
    private long id;

    @Column(nullable = false) //Column으로 지정
    private long userId;

    @Column(nullable=false) //Column으로 지정
    private String title;

    @Column(nullable=false, columnDefinition = "TEXT") //Column으로 지정
    private String content;
 
    //1대N의 방식을 표현하기 위한 Annotation, 새로운 테이블로 표현됨
    //기존 객체가 삭제되어 고립될 시 자동 삭제
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true) 
    private List<Attachment> pictures;

    @CreationTimestamp //자동 생성되는 시간, 현재 시간을 기준으로 생성
    @Column(updatable = false, nullable = false) //변경 불가능한 Column
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //포맷 지정
    private LocalDateTime created;

    @UpdateTimestamp //변경 시점의 시간을 저장
    @Column(nullable = false) //Column으로 할당
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") //포맷 지정
    private LocalDateTime modified;

    //각자의 값들을 받아서 Post로 표현하기 위한 생성자
    public Post(long userId, String title, String content)
    {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}