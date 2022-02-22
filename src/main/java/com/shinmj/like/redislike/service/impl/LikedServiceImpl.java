package com.shinmj.like.redislike.service.impl;

import com.shinmj.like.redislike.domain.LikedStatusEnum;
import com.shinmj.like.redislike.domain.UserLike;
import com.shinmj.like.redislike.service.LikedService;
import com.shinmj.like.redislike.service.RedisService;
import com.shinmj.like.redislike.service.repository.UserLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikedServiceImpl implements LikedService {

    @Autowired
    UserLikeRepository userLikeRepository;

    @Autowired
    RedisService redisService;

    @Override
    public UserLike save(UserLike userLike) {
        return userLikeRepository.save(userLike);
    }

    @Override
    public List<UserLike> saveAll(List<UserLike> list) {
        return userLikeRepository.saveAll(list);
    }

    @Override
    public Page<UserLike> getLikedListByLikedUserId(String likedUserId, Pageable pageable) {
        return userLikeRepository.findByLikedUserIdAndStatus(likedUserId, LikedStatusEnum.LIKE.getCode(), pageable);
    }

    @Override
    public Page<UserLike> getLikedListByLikedPostId(String likedPostId, Pageable pageable) {
        return userLikeRepository.findByLikedPostIdAndStatus(likedPostId, LikedStatusEnum.LIKE.getCode(), pageable);
    }

    @Override
    public UserLike getByLikedUserIdAndLikedPostId(String likedUserId, String likedPostId) {
        return userLikeRepository.findByLikedUserIdAndLikedPostId(likedUserId, likedPostId);
    }

    @Override
    public void transLikedFromRedis2DB() {
        List<UserLike> list = redisService.getLikedDataFromRedis();

        for (UserLike ul : list) {
            UserLike checked = getByLikedUserIdAndLikedPostId(ul.getLikedUserId(), ul.getLikedPostId());

            if(checked != null) {
                checked.setStatus(ul.getStatus());
                save(checked);
            }else {
                save(ul);
            }
        }
    }

    @Override
    public void transLikedCountFromRedis2DB() {

    }
}
