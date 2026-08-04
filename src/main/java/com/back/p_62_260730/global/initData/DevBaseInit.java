package com.back.p_62_260730.global.initData;

import com.back.p_62_260730.domain.post.member.entity.Member;
import com.back.p_62_260730.domain.post.member.service.MemberService;
import com.back.p_62_260730.domain.post.post.entity.Post;
import com.back.p_62_260730.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@Configuration // 빈 등록용
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Profile("dev")
public class DevBaseInit {

    private final PostService postService;
    private final MemberService memberService;

    @Lazy
    @Autowired
    private DevBaseInit self;

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("초기화 작업을 수행합니다.");

            work1();
            work2();

//            new Thread(() -> {
//                self.work3();
//            }).start();

            self.work4();

        };
    }

    // jpa -> jakarta, Transactional은 spring 패키지 사용

    @Transactional
    void work1() {

        if(postService.count() > 0) {
            return;
        }

        Member m1 = memberService.join("systemUser", "시스템");
        Member m2 = memberService.join("adminUser", "관리자");
        Member m3 = memberService.join("user1", "유저1");
        Member m4 = memberService.join("user2", "유저2");
        Member m5 = memberService.join("user3", "유저3");

        postService.write(m3.getId(), "제목1", "내용1");
        postService.write(m4.getId(),"제목2", "내용2");

    }


    void work2() {
        postService.findById(1);
        // select * from post where id = 1;
    }

    @Transactional
    void work3() {
        Post post1 = postService.findById(1).get();
        Post post2 = postService.findById(2).get();

        postService.delete(post1);

        if(true) {
            throw new RuntimeException("테스트 예외");
        }
        postService.delete(post2);
    }

    @Transactional
    void work4() {

        Post post1 = postService.findById(1).get();
        postService.modify(post1, "제목1-수정4", "내용1-수정4");
    }
}