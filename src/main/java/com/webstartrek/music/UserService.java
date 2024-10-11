package com.webstartrek.music;

import com.webstartrek.music.models.User;

public interface UserService {

    User getUser(String username);

    void saveUser(User user);
}
