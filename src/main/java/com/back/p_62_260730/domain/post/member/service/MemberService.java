package com.back.p_62_260730.domain.post.member.service;

import com.back.p_62_260730.domain.post.member.entity.Member;
import com.back.p_62_260730.domain.post.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member join(String username, String nickname) {
        return memberRepository.save(new Member(username, nickname));
    }

}