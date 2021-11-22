package com.stewart.server.config.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Stewart
 * @create 2021/11/22
 */
@Configuration
public class RedisConfig {
    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        ////参照StringRedisTemplate内部实现指定序列化器
        redisTemplate.setKeySerializer(keySerializer());
        redisTemplate.setHashKeySerializer(keySerializer());
        redisTemplate.setValueSerializer(valueSerializer());
        redisTemplate.setHashValueSerializer(valueSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    private RedisSerializer<String> keySerializer(){
        return new StringRedisSerializer();
    }

    //使用Jackson序列化器
    private RedisSerializer<Object> valueSerializer(){
        return new GenericJackson2JsonRedisSerializer();
    }
}
