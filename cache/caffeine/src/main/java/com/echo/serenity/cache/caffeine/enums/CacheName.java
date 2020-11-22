package com.echo.serenity.cache.caffeine.enums;

/**
 * 关于Cache的配置方式有两种：
 * 1. application.yml
 * 2. 配置类
 * 前者配置简单、无需代码，但无法针对每个cache配置不同的参数，比如过期时长、最大容量等
 * 因此这里定义一个cache的枚举类，用于灵活配置每个cache的 { 过期时长和 最大容量 }
 */
public enum CacheName {
    USER(10);

    private static final int DEFAULT_MAXSIZE  = 1000;
    private static final int DEFAULT_TTL = 10; //单位s

    int ttl;
    int maxSize;

    CacheName(int ttl) {
        this(ttl, DEFAULT_MAXSIZE);
    }

    CacheName(int ttl, int maxSize) {
        this.ttl = ttl;
        this.maxSize = maxSize;
    }

    public int getTtl() {
        return ttl;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
