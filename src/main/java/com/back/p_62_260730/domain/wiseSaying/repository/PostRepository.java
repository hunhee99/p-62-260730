package com.back.p_62_260730.domain.wiseSaying.repository;

import com.back.p_62_260730.domain.wiseSaying.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<사용할 객체, 식별자의 자료형>
/*
기본으로 사용 가능한 기능들
    save(): 엔티티 저장
    findById(): ID로 엔티티 조회
    findAll(): 모든 엔티티 조회
    delete(): 엔티티 삭제
    count(): 엔티티 개수 조회
 */
public interface PostRepository extends JpaRepository<Post, Integer> {
}