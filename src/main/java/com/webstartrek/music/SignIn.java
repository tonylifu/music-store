package com.webstartrek.music;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Data
@Named
@RequestScoped
public class SignIn {

    @Inject
    private UserManager userManager;

    private String username;
    private String password;

    public String submit() {
        return userManager.signIn(username, password);
    }
}