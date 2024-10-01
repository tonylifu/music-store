package com.webstartrek.music;

public interface UserService {

    User getUser(String username);

    void saveUser(User user);
}
