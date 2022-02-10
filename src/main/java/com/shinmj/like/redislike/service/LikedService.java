package com.shinmj.like.redislike.service;

import com.shinmj.like.redislike.domain.UserLike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikedService {

    /**
     * Save like record
     * @param userLike
     * @return
     */
    UserLike save(UserLike userLike);


    /**
     * Batch save or modify
     * @param list
     * @return
     */
    List<UserLike> saveAll(List<UserLike> list);

    /**
     *
     * @param likedUserId the id of the liked person
     * @param pageable
     * @return
     */
    Page<UserLike> getLikedListByLikedUserId(String likedUserId, Pageable pageable);

    /**
     * 좋아요를 누른 사람의 아이디를 기준으로 좋아요 목록 조회
     * @param likedPostId
     * @param pageable
     * @return
     */
    Page<UserLike> getLikedListByLikedPostId(String likedPostId, Pageable pageable);

    /**
     * like, like person id로 같은 기록이 있는지 조회
     * @param likedUserId
     * @param likedPostId
     * @return
     */
    UserLike getByLikedUserIdAndLikedPostId(String likedUserId, String likedPostId);

    /**
     * Store the like data in Redis into the database
     */
    void transLikedFromRedis2DB();

    /**
     * Store the number of likes in Redis into the database
     */
    void transLikedCountFromRedis2DB();
}
