package com.shinmj.like.redislike.service;

import com.shinmj.like.redislike.domain.LikedCountDTO;
import com.shinmj.like.redislike.domain.UserLike;

import java.util.List;

public interface RedisService {

    /**
     * like. Status is 1
     * @param likedUserId
     * @param likedPostId
     */
    void saveLiked2Redis(String likedUserId, String likedPostId);

    /**
     * Cancel the like. Change state to 0
     * @param likedUserId
     * @param likedPostId
     */
    void unlikeFromRedis(String likedUserId, String likedPostId);


    /**
     * Delete a like data from Redis
     * @param likedUserId
     * @param likedPostId
     */
    void deleteLikedFromRedis(String likedUserId, String likedPostId);

    /**
     * The user's likes plus 1
     * @param likedUserId
     */
    void incrementLikedCount(String likedUserId);

    /**
     * The number of likes of the user minus 1
     * @param likedUserId
     */
    void decrementLikedCount(String likedUserId);

    /**
     * Get all the like data stored in Redis
     * @return
     */
    List<UserLike> getLikedDataFromRedis();

    /**
     * Get the number of all likes stored in Redis
     * @return
     */
    List<LikedCountDTO> getLikedCountFromRedis();
}
