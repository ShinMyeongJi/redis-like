package com.shinmj.like.redislike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisLikeApplication {

    public static void main(String[] args) {
        System.out.println(org.springframework.core.SpringVersion.getVersion());
        SpringApplication.run(RedisLikeApplication.class, args);
    }

}
