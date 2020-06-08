package kr.hs.dgsw.blog.Domain;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //클래스를 Entity로 지정
@NoArgsConstructor //인자가 없는 생성자를 생성
@Data //변수들의 Getter, Setter과 클래스의 ToString 자동 생성
public class User {
    @Id //테이블에서 Id로 사용
    @GeneratedValue(strategy=GenerationType.IDENTITY) //mysql방식에 의해 autoIncreasement로 지정
    private long id;

    @Column(nullable=false,unique=true,length=20) //Column으로 지정, 유니크로 지정하여 테이블 내에서 유일한 값을 가짐
    private String account;
 
    @Column(nullable=false) //Column으로 지정
    @JsonProperty(access=JsonProperty.Access.WRITE_ONLY) //쓰기 전용, 변경 불가능
    private String password;

    public void setPassword(String password) //비밀번호를 암호화하기 위한 함수
    {
        try{
            MessageDigest md =MessageDigest.getInstance("SHA-512");
            md.update(password.getBytes(),0,password.getBytes().length);
            this.password= new BigInteger(1, md.digest()).toString(16);
        } catch(NoSuchAlgorithmException e){
            Logger logger = LoggerFactory.getLogger(User.class);
            logger.warn(e.getMessage());
        }
    }

    @Column(nullable=false) //Column으로 지정
    private String name;

    @Column(unique=true) //Column으로 지정, 유일한 값을 갖도록 함
    private String email;

    @Column(unique=true) //Column으로 지정, 유일한 값을 갖도록 함
    private String phone;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //쓰기 전용, 변경 불가능
    private String profilePath;

    @CreationTimestamp //자동 생성되는 시간, 현재 시간을 기준으로 생성
    @Column(updatable=false, nullable=false) //변경 불가능한 Column
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") //포맷 지정
    private LocalDateTime created;

    @UpdateTimestamp //변경 시점의 시간을 저장
    @Column(nullable=false) //Column으로 할당
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss") //포맷 지정
    private LocalDateTime modified;

    //각자의 값들을 받아서 User로 표현하기 위한 생성자
    public User(String account, String password, String name, String email, String phone, String profilePath)
    {
        this.account = account;
        setPassword(password);
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.profilePath = profilePath;
    }
}