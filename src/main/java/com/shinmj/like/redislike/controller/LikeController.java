package com.shinmj.like.redislike.controller;

import com.shinmj.like.redislike.service.LikedService;
import com.shinmj.like.redislike.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = LikeController.LIKE)
public class LikeController {

    public static final String LIKE = "/like";
    public static final String USER_ID = "/{userId}";
    public static final String POST_ID = "/{postId}";

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisService redisService;

    @RequestMapping(
            value = POST_ID + USER_ID,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createLike(
        @PathVariable String postId,
        @PathVariable String userId
    ) {
        redisService.saveLiked2Redis(userId, postId);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(
            value = POST_ID + USER_ID,
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> cancleLike(
            @PathVariable String postId,
            @PathVariable String userId
    ) {
       redisService.deleteLikedFromRedis(userId, postId);
       return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getLikedData() {
        redisService.getLikedDataFromRedis();
        return null;
    }


}
