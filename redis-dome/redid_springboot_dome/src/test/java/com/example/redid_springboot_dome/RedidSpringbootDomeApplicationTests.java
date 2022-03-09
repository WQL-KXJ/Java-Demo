package com.example.redid_springboot_dome;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class RedidSpringbootDomeApplicationTests {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @DisplayName("Springboot和redis整合测试！")
    @Test
    void redis_test() {

        redisTemplate.opsForValue().set("wql",10);

        SessionCallback sessionCallback = new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.watch("wql");
                redisOperations.multi();

                //redisOperations.opsForValue().set("wql",666);
                return redisOperations.exec();
            }
        };

        redisTemplate.execute(sessionCallback);

    }

        @Test
        void redis_test1() {
            redisTemplate.opsForValue().set("wql",999);
    }

}
