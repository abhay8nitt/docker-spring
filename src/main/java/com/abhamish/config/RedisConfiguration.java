package com.abhamish.config;

import com.abhamish.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JacksonJsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
//@PropertySource("application.properties")
public class RedisConfiguration {
    @Autowired
    /**
     * By default it takes the default configuration of localhost and port 6379
     */
    // @Value("${redis.hostname}")
    //private String redisHostName;

    //@Value("${redis.port}")
    //private int redisPort;
    /**
     * @Bean
    JedisConnectionFactory jedisConnectionFactory() {
    JedisConnectionFactory factory = new JedisConnectionFactory();
    factory.setHostName(redisHostName);
    factory.setPort(redisPort);
    factory.setUsePool(true);
    return factory;
    }
     @Bean
     RedisCacheManager cacheManager() {
     RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
     return redisCacheManager;
     }
     */
    private JedisConnectionFactory jedisConnFactory;

    @Bean
    public StringRedisSerializer stringRedisSerializer() {
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        return stringRedisSerializer;
    }

    @Bean
    public Jackson2JsonRedisSerializer<Student> jacksonJsonRedisJsonSerializer() {
        Jackson2JsonRedisSerializer<Student> jacksonJsonRedisJsonSerializer = new Jackson2JsonRedisSerializer<>(Student.class);
        return jacksonJsonRedisJsonSerializer;
    }

    @Bean
    public RedisTemplate<String, Student> redisTemplate() {
        RedisTemplate<String, Student> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnFactory);
        redisTemplate.setKeySerializer(stringRedisSerializer());
        redisTemplate.setValueSerializer(jacksonJsonRedisJsonSerializer());
        return redisTemplate;
    }
}
