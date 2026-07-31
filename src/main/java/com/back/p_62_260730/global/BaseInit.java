package com.back.p_62_260730.global;

import com.back.p_62_260730.domain.wiseSaying.entity.Post;
import com.back.p_62_260730.domain.wiseSaying.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 빈 등록용
public class BaseInit {

    @Autowired
    private PostRepository postRepository;

    @Bean
    public ApplicationRunner init(){
        return args -> {
            System.out.println("초기화 작업을 수행합니다.");

//            if (postRepository.count() > 0) {
//                return;
//            }
//
//            // SELECT COUNT(*) FROM post;
//            postRepository.count();
//
//
//            // post 하나 저장
//            Post post = new Post("제목1", "내용1");
//            postRepository.save(post);
//            /*
//            [Hibernate]
//            insert
//            for
//                com.back.p_62_260730.domain.wiseSaying.entity.Post
//            insert
//            into
//            post (body, title, id)
//            values
//                    (?, ?, default)
//             */
//
//
//            // post 조회
//            // Optional로 반환함
//            Optional<Post> opPost =  postRepository.findById(1);
//
//            if (opPost.isPresent()){
//                System.out.println(opPost.get().getTitle());
//                System.out.println(opPost.get().getBody());
//                /*
//                [Hibernate]
//                select
//                    p1_0.id,
//                    p1_0.body,
//                    p1_0.title
//                from
//                    post p1_0
//                where
//                    p1_0.id=?
//                */
//            }

            work1();
            work2();
        };
    }

    void work1() {

        if(postRepository.count() > 0) {
            return;
        }

        Post post1 = new Post("제목1", "내용1");
        postRepository.save(post1);

        Post post2 = new Post("제목2", "내용2");
        postRepository.save(post2);
    }

    void work2() {
        postRepository.findById(1);
        // select * from post where id = 1;
    }
}
