package com.back.p_62_260730.domain.post.post.service;


import com.back.p_62_260730.domain.post.post.entity.Post;
import com.back.p_62_260730.domain.post.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // @Component랑 같은 역할이지만 좀 더 명시적
@RequiredArgsConstructor
public class PostService {

    // @Autowired // 객체가 다 생성된 후 연결, 생성자는 객체 생성 중 연결
    // 빈 연결 시에는 생성자가 안전
    private final PostRepository postRepository;    // 레포의 메소드 단위로 트렌젝션 잡힘


    public Post write(int authorId, String title, String body){
        Post post = new Post(authorId, title, body);
        postRepository.save(post);  // INSERT INTO .. DB에 반영됨

        // 저장을 했으면 저장한 값을 반환하는 게 관례
        return post; // 기본적으로 jpa가 제공하는 기능은 트렌젝션 -> 커밋 기능을 갖는다.
    }

    // 수정
    public void modify(Post post, String title, String body){
        post.modify(title, body);

    }


    public Optional<Post> findById(int id){
        return postRepository.findById(id); // 트렌젝션 시작 -> SELECT * FROM post -> 트렌젝션 종료 -> 커밋
    }

    public long count(){
        return postRepository.count();
    }

    public void delete(Post post) {
        postRepository.delete(post);
    }
}
