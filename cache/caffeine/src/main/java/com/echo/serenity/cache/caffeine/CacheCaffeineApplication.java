package com.echo.serenity.cache.caffeine;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.echo.serenity.cache.caffeine.enums.CacheName;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;

@SpringBootApplication
@EnableCaching
public class CacheCaffeineApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheCaffeineApplication.class);

    /**
     * initialCapacity=[integer]: 初始的缓存空间大小
     * maximumSize=[long]: 缓存的最大条数
     * maximumWeight=[long]: 缓存的最大权重
     * expireAfterAccess=[duration]: 最后一次写入或访问后经过固定时间过期
     * expireAfterWrite=[duration]: 最后一次写入后经过固定时间过期
     * refreshAfterWrite=[duration]: 创建缓存或者最近一次更新缓存后经过固定的时间间隔，刷新缓存
     *                               Guava在并发场景下有「更新锁定」的特性，对于同一个Key，只让一个请求去源中读取数据，而其他请求阻塞等待结果
     * weakKeys: 打开key的弱引用
     * weakValues：打开value的弱引用
     * softValues：打开value的软引用
     * recordStats：开发统计功能
     * <p>
     * expireAfterWrite和expireAfterAccess同事存在时，以expireAfterWrite为准。
     * maximumSize和maximumWeight不可以同时使用
     * weakValues和softValues不可以同时使用
     */
    @Bean(value = "caffeine")
    //如果使用了多个cache，比如redis、caffeine等，必须指定某一个CacheManage为@primary
    //在@Cacheable注解中没指定 cacheManager则使用标记为primary的那个。
    @Primary
    public CacheManager caffeineCacheManager() {
        List<CaffeineCache> caches = Arrays.stream(CacheName.values()).map(c -> {
            Cache<Object, Object> cache = Caffeine.newBuilder()
                    .recordStats()
                    .expireAfterAccess(c.getTtl(), TimeUnit.SECONDS)
                    .refreshAfterWrite(5, TimeUnit.SECONDS)
                    .maximumSize(c.getMaxSize())
                    .build();
            return new CaffeineCache(c.name(), cache);
        }).collect(Collectors.toList());
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(caches);
        return cacheManager;
    }

    @Bean(value = "caffeine2")
    public CacheManager caffeineCacheManager2() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
        for (CacheName c : CacheName.values()) {
            Cache<Object, Object> cache = Caffeine.newBuilder()
                    .recordStats()
                    .expireAfterAccess(c.getTtl(), TimeUnit.SECONDS)
                    .refreshAfterWrite(5, TimeUnit.SECONDS)
                    .maximumSize(c.getMaxSize())
                    .build();
            caffeineCacheManager.registerCustomCache(c.name(), cache);
        }
        return caffeineCacheManager;
    }

    /*
        必须要指定这个Bean，refreshAfterWrite=5s这个配置属性才生效
     */
    @Bean
    public CacheLoader<Object, Object> cacheLoader() {
        return new CacheLoader<Object, Object>() {
            @Override
            public Object load(Object key) throws Exception {
                return null;
            }

            // 重写这个方法将oldValue值返回回去，进而刷新缓存
            @Override
            public Object reload(Object key, Object oldValue) throws Exception {
                return oldValue;
            }
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(CacheCaffeineApplication.class, args);
    }

}
