package com.shinmj.like.redislike.service.impl;

import com.shinmj.like.redislike.domain.LikedCountDTO;
import com.shinmj.like.redislike.domain.LikedStatusEnum;
import com.shinmj.like.redislike.domain.UserLike;
import com.shinmj.like.redislike.service.LikedService;
import com.shinmj.like.redislike.service.RedisService;
import com.shinmj.like.redislike.utils.RedisKeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisKeyExpiredEvent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public void saveLiked2Redis(String likedUserId, String likedPostId) {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likedPostId);
        //redisTemplate.opsForSet().add(likedPostId, likedUserId);
        redisTemplate.opsForHash().put(RedisKeyUtils.MAP_KEY_USER_LIKED, key, LikedStatusEnum.LIKE.getCode());
    }

    @Override
    public void unlikeFromRedis(String likedUserId, String likedPostId) {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likedPostId);
        redisTemplate.opsForHash().put(RedisKeyUtils.MAP_KEY_USER_LIKED, key, LikedStatusEnum.UNLIKE.getCode());

    }

    @Override
    public void deleteLikedFromRedis(String likedUserId, String likedPostId) {
        String key = RedisKeyUtils.getLikedKey(likedUserId, likedPostId);
        redisTemplate.opsForHash().delete(RedisKeyUtils.MAP_KEY_USER_LIKED, key);
    }

    @Override
    public void incrementLikedCount(String likedUserId) {
        redisTemplate.opsForHash().increment(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, likedUserId, 1);
    }

    @Override
    public void decrementLikedCount(String likedUserId) {
        redisTemplate.opsForHash().increment(RedisKeyUtils.MAP_KEY_USER_LIKED_COUNT, likedUserId, -1);
    }

    @Override
    public List<UserLike> getLikedDataFromRedis() {
        Cursor<Map.Entry<Object, Object>> cursor = redisTemplate.opsForHash().scan(RedisKeyUtils.MAP_KEY_USER_LIKED, ScanOptions.NONE);

        List<UserLike> list = new ArrayList<>();

        while(cursor.hasNext()) {
            Map.Entry<Object, Object> entry = cursor.next();

            String key[] = ((String)entry.getKey()).split(RedisKeyUtils.KEY_JOIN);

            list.add(UserLike.builder()
                    .likedUserId(key[0])
                    .likedPostId(key[1])
                    .status((Integer)entry.getValue())
                    .build()
            );
        }
        return list;
    }

    @Override
    public List<LikedCountDTO> getLikedCountFromRedis() {
        return null;
    }
}
