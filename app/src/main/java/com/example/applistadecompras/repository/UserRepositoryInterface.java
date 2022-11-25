package com.example.applistadecompras.repository;

import com.example.applistadecompras.model.User;


import java.util.List;

public interface UserRepositoryInterface {


    public long addUser(User user);
    public long delete(User user);
    public List<User> getUsers();
    public User getUserByUserLogin(String login);

}
