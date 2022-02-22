package com.shinmj.like.redislike.utils;

public class RedisKeyUtils {
    public static final String MAP_KEY_USER_LIKED = "MAP_USER_LIKED";

    public static final String MAP_KEY_USER_LIKED_COUNT = "MAP_USER_LIKED_COUNT";
    public static final String KEY_JOIN = "::";

    /**
     * 좋아한 사람의 아이디와 게시글 아이디를 Key로 연결한다.
     * @param likedUserId
     * @param likedPostId
     * @return
     */
    public static String getLikedKey(String likedUserId, String likedPostId) {
        StringBuilder stringBuilder = new StringBuilder();

        return stringBuilder.append(likedUserId)
                .append(KEY_JOIN)
                .append(likedPostId)
                .toString();
    }
}
