package com.shinmj.like.redislike.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NonNull
    private String likedUserId;

    @NonNull
    private String likedPostId;

    @NonNull
    private Integer status = LikedStatusEnum.UNLIKE.getCode();
}
