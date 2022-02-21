package com.shinmj.like.redislike.domain;

import lombok.Getter;

@Getter
public enum LikedStatusEnum {
    LIKE(1, "Like"),
    UNLIKE(0, "CancelLike/Not Like"),;

    private int code;
    private String msg;

    LikedStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
