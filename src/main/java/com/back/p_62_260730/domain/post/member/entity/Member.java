package com.back.p_62_260730.domain.post.member.entity;

import com.back.p_62_260730.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member extends BaseEntity {

    private String username;
    private String nickname;

    public Member(String username, String nickname) {
        this.username = username;
        this.nickname = nickname;
    }
}