package com.shinmj.like.redislike.domain.response.liked;


import com.shinmj.like.redislike.domain.LikedStatusEnum;
import lombok.Builder;


@Builder
public class UserLike {
//    private String MAP_USER_LIKED;
    private String likedUserId;
    private String likedPostId;
    private Integer status;
}
