package com.echo.serenity.cache.caffeine.service;

import com.echo.serenity.cache.caffeine.model.User;

import java.util.List;

public interface UserService {

    /**
     * 查找所有
     * @return
     */
    List<User> queryAll();

    /**
     * 根据id获取用户
     * @param userId
     * @return
     */
    User queryById(long userId);

    /**
     * 新增用户
     * @param user
     */
    void addUser(User user);


    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userId
     */
    void deleteUser(long userId);

    /**
     * 删除多用户
     * @param userIds
     */
    void deleteUsers(List<Long> userIds);


}
