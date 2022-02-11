package com.shinmj.like.redislike.controller;

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

    @RequestMapping(
            value = POST_ID + USER_ID,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createLike(
        @PathVariable String postId,
        @PathVariable String userId
    ) {
        ValueOperations vop = redisTemplate.opsForValue();
        vop.set(postId + userId, 1 + "");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
