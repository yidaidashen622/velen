package com.echo.serenity.cache.caffeine.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import com.echo.serenity.cache.caffeine.dao.UserDao;
import com.echo.serenity.cache.caffeine.model.User;
import com.echo.serenity.cache.caffeine.service.UserService;

@Service
@CacheConfig(cacheNames = "userCache")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(cacheNames = "userList")
    public List<User> queryAll() {

        return userDao.select();
    }

    //SpEL提供了多种运算符，比如le ne等等
    @Override
    @Cacheable(cacheNames = "user", key = "#userId", sync = true)
    public User queryById(long userId) {
        return userDao.selectById(userId);
    }

    @Override
    @CachePut(cacheNames = "user", key = "#user.id")
    public void addUser(User user) {
        userDao.insert(user);
    }

    @Caching(
            put = {
                    @CachePut(value = "user", key = "#user.id"),
                    @CachePut(value = "user", key = "#user.name")
            }
    )
    //这类复杂的，如果是通用的话，可以封装为一个注解，比如@UserSaveCache
    //理论上id映射对象，name也映射对象，对象就重复了，能不能name映射id，然后再根据id找到对象呢？ 也就是二级索引的概念
    public void addUserMoreCache(User user) {
        userDao.insert(user);
    }

    @Override
    @CacheEvict(cacheNames = "user", key = "#user.id")
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Override
    @CacheEvict(cacheNames = "user", key = "#userId", beforeInvocation = false)
    public void deleteUser(long userId) {
        userDao.delete(userId);
    }

    /*
        对于类似这种需要一次刷新很多缓存对象的需求，目前没有直接的支持方法，在真正使用时需要考虑这一缺点
     */
    @Override
    public void deleteUsers(List<Long> userIds) {

    }


}


