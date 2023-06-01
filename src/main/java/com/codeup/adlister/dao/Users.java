package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

public interface Users {
    User findByUsername(String username);
    Long insert(User user);

    User findById (long Id);
    void update(User user);

    void deleteUser(User user);

}
