package com.nateshao.mybatis.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @date Created by 邵桐杰 on 2021/12/24 18:14
 * @微信公众号 千羽的编程时光
 * @个人网站 www.nateshao.cn
 * @博客 https://nateshao.gitee.io
 * @GitHub https://github.com/nateshao
 * @Gitee https://gitee.com/nateshao
 * Description:
 */
@Configuration
public class RedisConfig {
    /**
     * 重写Redis序列化方式，使用Json方式
     * 当我们的数据存储到Redis的时候，我们的键和值都是通过Spring提供的Serializer序列化到Redis的
     * RedisTemplate默认使用的是JdkSerializationRedisSerializer
     * StringRedisTemplate默认使用的是StringRedisSerializer
     *
     * Spring Data JPA为我们提供了下面的Serializer：
     * GenericToStringSerializer、JackSonJsonRedisSerializer、OxmSerializer、StringRedisSerializer
     *
     **/

    //配置自己的RedisTemplate并定义Serializer
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        //创建一个json的序列化对象
        GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        //设置value的序列化json
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        //设置key序列化json
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置Hash key序列化String
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        //设置Hash value序列化String
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();

        return redisTemplate;
    }
}