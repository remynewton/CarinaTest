package com.laba.solvd.db.mappers;

import com.laba.solvd.db.models.User;

public interface UserMapper {

    void create(User user);

    User findById(long id);

    User findByUserName(String username);

    void update(User user);

    void delete(User user);
}