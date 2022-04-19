package com.shinmj.like.redislike.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shinmj.like.redislike.domain.UserLike;
import com.shinmj.like.redislike.domain.response.BasicResponse;
import com.shinmj.like.redislike.domain.response.CommonResponse;
import com.shinmj.like.redislike.domain.response.ErrorResponse;
import com.shinmj.like.redislike.domain.response.liked.UserLikeResponse;
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

import java.util.List;


@RestController
@RequestMapping(value = LikeController.LIKE)
public class LikeController {

    public static final String LIKE = "/like";
    public static final String TRANS_DB = "/trans";
    public static final String USER_ID = "/{userId}";
    public static final String POST_ID = "/{postId}";


    @Autowired
    private RedisService redisService;


    @Autowired
    private LikedService likedService;

    /**
     * 좋아요 추가 (게시물 + 좋아요한 사용자 ID)
     * @param postId
     * @param userId
     * @return
     */
    /*@RequestMapping(
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
    }*/
    @RequestMapping(
            value = POST_ID + USER_ID,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<? extends BasicResponse> createLike(
            @PathVariable String postId,
            @PathVariable String userId
    ) {
        UserLikeResponse userLikeResponse = redisService.saveLiked2Redis(userId, postId);

        if (userLikeResponse == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("좋아요 정보 캐시 서버 전송 실패"));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(new CommonResponse<>(userLikeResponse));
    }



    /**
     * 좋아요 취소 (게시물 + 취소한 사용자 ID)
     * @param postId
     * @param userId
     * @return
     */
    @RequestMapping(
            value = POST_ID + USER_ID,
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> cancelLike(
            @PathVariable String postId,
            @PathVariable String userId
    ) {
       UserLikeResponse userLikeResponse = redisService.deleteLikedFromRedis(userId, postId);

       if (userLikeResponse == null) {
           return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorResponse("삭제하려는 좋아요 정보가 존재하지 않습니다."));
       }
       return ResponseEntity.ok().body(new CommonResponse<>(userLikeResponse));
    }

    /**
     * 좋아요 목록 가져오기
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getLikedData() throws JsonProcessingException {
        List<UserLike> userLikeList = redisService.getLikedDataFromRedis();

        if (userLikeList == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorResponse("좋아요 목록을 가져오는데 실패했습니다."));
        }

        return ResponseEntity.ok().body(new CommonResponse<>(redisService.getLikedDataFromRedis()));
    }


    /**
     * 좋아요 정보 Redis -> DB 전송
     * @return
     */
    @RequestMapping(
            value = TRANS_DB,
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> transLikedFromRedis2DB() {
        List<UserLike> userLikeList = likedService.transLikedFromRedis2DB();

        if (userLikeList == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ErrorResponse("DB로 전송할 좋아요 목록이 없습니다."));
        }
        return ResponseEntity.ok().body(new CommonResponse<>(userLikeList));
    }
}
