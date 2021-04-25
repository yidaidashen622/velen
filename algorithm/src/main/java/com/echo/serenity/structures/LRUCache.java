package com.echo.serenity.structures;

import java.util.LinkedHashMap;

import com.google.common.collect.Maps;

/**
 * Created by xushu.
 */
public class LRUCache {

    private final int capacity;
    private final LinkedHashMap<String, Integer> cache = Maps.newLinkedHashMap();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(String key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        markRecently(key);
        return cache.get(key);
    }

    public void put(String key, Integer value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            markRecently(key);
        }
        if (cache.size() < capacity) {
            cache.put(key, value);
            return;
        }
        String oldestKey = cache.keySet().iterator().next();
        cache.remove(oldestKey);
    }

    private void markRecently(String key) {
        Integer value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }


}
