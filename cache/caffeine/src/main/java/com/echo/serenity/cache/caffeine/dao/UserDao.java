package com.echo.serenity.cache.caffeine.dao;

import com.echo.serenity.cache.caffeine.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class UserDao {
    public static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    public long insert(User user){
        return 1L;
    }

    public void delete(long userId) {

    }

    public int update(User user) {
        return 1;
    }

    public List<User> select(){
        return Collections.emptyList();
    }

    public User selectById(long userId){
        return new User();
    }


}
