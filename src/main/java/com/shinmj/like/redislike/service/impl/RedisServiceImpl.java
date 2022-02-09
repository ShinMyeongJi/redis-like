package com.shinmj.like.redislike.service.impl;

import com.shinmj.like.redislike.domain.LikedCountDTO;
import com.shinmj.like.redislike.domain.UserLike;
import com.shinmj.like.redislike.service.LikedService;
import com.shinmj.like.redislike.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    LikedService likedService;


    @Override
    public void saveLiked2Redis(String likedUserId, String likedPostId) {

    }

    @Override
    public void unlikeFromRedis(String likedUserId, String likedPostId) {

    }

    @Override
    public void deleteLikedFromRedis(String likedUserId, String likedPostId) {

    }

    @Override
    public void incrementLikedCount(String likedUserId) {

    }

    @Override
    public void decrementLiedCount(String likedUserId) {

    }

    @Override
    public List<UserLike> getLikedDataFromRedis() {
        return null;
    }

    @Override
    public List<LikedCountDTO> getLikedCountFromRedis() {
        return null;
    }
}
