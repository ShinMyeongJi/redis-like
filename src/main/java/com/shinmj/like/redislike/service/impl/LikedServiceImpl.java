package com.shinmj.like.redislike.service.impl;

import com.shinmj.like.redislike.domain.UserLike;
import com.shinmj.like.redislike.service.LikedService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedServiceImpl implements LikedService {
    @Override
    public UserLike save(UserLike userLike) {
        return null;
    }

    @Override
    public List<UserLike> saveAll(List<UserLike> list) {
        return null;
    }

    @Override
    public Page<UserLike> getLikedListByLikedUserId(String likedUserId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<UserLike> getLikedListByLikedPostId(String likedPostId, Pageable pageable) {
        return null;
    }

    @Override
    public UserLike getByLikedUserIdAndLikedPostId(String likedUserId, String likedPostId) {
        return null;
    }

    @Override
    public void transLikedFromRedis2DB() {

    }

    @Override
    public void transLikedCountFromRedis2DB() {

    }
}
