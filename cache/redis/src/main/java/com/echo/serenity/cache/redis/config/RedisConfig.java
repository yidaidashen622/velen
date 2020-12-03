package com.echo.serenity.cache.redis.config;

import java.lang.reflect.Method;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@ConditionalOnProperty(name = "xx.xx.xx", havingValue = "redis", matchIfMissing = true)
public class RedisConfig extends CachingConfigurerSupport {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisConfig.class);

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        //通过配置RedisStandaloneConfiguration实例来创建Redis Standalone模式的客户端连接创建工厂
        //RedisProperties
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }

    @Bean //非常关键的配置
    @Override
    public CacheManager cacheManager() {
        /*
            RedisCacheManager最关键的两个参数 RedisConnectionFactory & RedisCacheWriter
            RedisConnectionFactory, Thread-safe factory of Redis connections, Jedis & Lettuce 两个实现版本
                Jedis是非线程安全的client，其提供了JedisPool类，详情可见https://www.cnblogs.com/albertzhangyu/p/13745818.html
                Lettuce则是线程安全的Client，其只需要管理ConnectionPool就可以
            RedisCacheWriter，有加锁与不加锁两个版本，详见DefaultRedisCacheWriter(RedisConnectionFactory zf, Duration sleepTime) 构造函数
         */
        return RedisCacheManager.create(redisConnectionFactory());
    }

    @Override
    public CacheResolver cacheResolver() {
        return new CacheResolver() {
            @Override
            public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
                return null;
            }
        };
    }

    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return null;
            }
        };
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {

            }

            @Override
            public void handleCachePutError(RuntimeException exception, Cache cache, Object key, Object value) {

            }

            @Override
            public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {

            }

            @Override
            public void handleCacheClearError(RuntimeException exception, Cache cache) {

            }
        };
    }
}
