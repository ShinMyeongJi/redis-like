package com.shinmj.like.redislike.service.repository;

import com.shinmj.like.redislike.domain.UserLike;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLikeRepository extends JpaRepository<UserLike, Integer> {

    Page<UserLike> findByLikedUserIdAndStatus(String likedUserId, int likedStatusCode, Pageable pageable);

    Page<UserLike> findByLikedPostIdAndStatus(String likedPostId, int likedStatusCode, Pageable pageable);

    UserLike findByLikedUserIdAndLikedPostId(String likedUserId, String likedPostId);

}
