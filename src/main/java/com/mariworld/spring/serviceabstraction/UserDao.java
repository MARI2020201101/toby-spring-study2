package com.mariworld.spring.serviceabstraction;

import java.util.List;

public interface UserDao {

    List<User> getAll();
    User get(String id);
    void add(User user);
    void update(User user);
    void deleteAll();
}
