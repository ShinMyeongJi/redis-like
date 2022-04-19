package com.shinmj.like.redislike.domain.response.liked;


import com.shinmj.like.redislike.domain.LikedStatusEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// 응답 Response 작성 1차 시도
@Builder
@Getter
@Setter
public class UserLikeResponse {
//    private String MAP_USER_LIKED;
    private String likedUserId;
    private String likedPostId;
    private Integer status;
}
