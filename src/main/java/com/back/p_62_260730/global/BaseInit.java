package com.back.p_62_260730.global;

import com.back.p_62_260730.domain.post.entity.Post;
import com.back.p_62_260730.domain.post.repository.PostRepository;
import com.back.p_62_260730.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.transaction.annotation.Transactional;

@Configuration // 빈 등록용
@RequiredArgsConstructor
// @Transactional(readOnly = true) // 미리 읽기용으로 걸고 아닌 애들만 오버로딩
public class BaseInit {

    @Lazy
    @Autowired
    private BaseInit self;

    private final PostService postService;

    @Autowired
    private PostRepository postRepository;  // 창고 관리인

    @Bean
    public ApplicationRunner init(){
        return args -> {
            System.out.println("초기화 작업을 수행합니다.");

            work1();
            work2();

//            new Thread(()->{
//                self.work3();
//            }).start();
            
            work4();
        };
    }

    // jpa 관련은 보통 jakarta 사용하지만, Transactional은 spring 라이브러리 사용
    @Transactional
    void work1() {

        if(postService.count() > 0) {
            return;
        }

        postService.write("제목1", "내용1");
        postService.write("제목2", "내용2");
    }

//    // 조회 작업에 그냥 트렌젝션을 걸면 비효율적임. 옵션을 붙이면 효율적으로
    @Transactional(readOnly = true)
    void work2() {
        // postRepository.findById(1);
        // select * from post where id = 1;
        postRepository.findById(1);

    }

    @Transactional
    void work3() {
        Post post1 = postService.findById(1).get();
        Post post2 = postService.findById(2).get();

        postService.delete(post1);
        if (true){
            throw new RuntimeException("예외 발생");
        }
        postService.delete(post2);
    }

    @Transactional
    void work4() {
        Post post1 = postService.findById(1).get();
        postService.modify(post1, "제목1-수정", "내용1-수정");
    }
}
