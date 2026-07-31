package com.back.p_62_260730.domain.post.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


/*
@AllArgsConstructor
이건 id를 지정하는 거라서 쓰면 안됨
 */

@Setter
@Getter // 어노테이션. 표식(자바, 프레임워크, IDE)
@Entity // 클래스와 같은 Table을 DB에 만들어 줌
@NoArgsConstructor
// @RequiredArgsConstructor    // final 변수만 생성자 매개변수로 가능
@EntityListeners(AuditingEntityListener.class)
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // INT
    // 제목
    private String title; // VARCHAR(255)
    // 내용
    private String body; // VARCHAR(255)
    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

//    // 추가적인 생성자가 있으면 기본 생성자는 자동 생성이 안됨. 만들 것 @NoArgsConstructor 이거 있으면 ㄱㅊ
//    public Post(){
//        this.title = "";
//        this.body = "";
//    }

//    public Post() {
//        this.id = 0;
//    }

    // JPA reflection에 의해 기본 생성자 없이는 불가
    public Post(String title, String body){
//        this.id = 0;
        this.title = title;
        this.body = body;
        this.createDate = LocalDateTime.now();
        this.modifyDate = createDate;
    }

    // id를 final로 설정하지 않고 롬북과의 조합을 사용할 때, id를 만지는 것을 방지할 수 있음
    public void setId(int id){
        throw new RuntimeException("id 사용 불가");
    }

}