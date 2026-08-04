package com.back.p_62_260730;

import com.back.p_62_260730.domain.post.post.entity.Post;
import com.back.p_62_260730.domain.post.post.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional // rollback 기능
@ActiveProfiles("test")
public class P62260730ApplicationTests {

	@Autowired
	private PostRepository postRepository;

	@Test
	@DisplayName("2번 글 조회")
	void t1() {
		Post post1 = postRepository.findById(2).get();

		assertThat(post1.getId()).isEqualTo(2);
		assertThat(post1.getTitle()).isEqualTo("제목2");
		assertThat(post1.getBody()).isEqualTo("내용2");

	}
}