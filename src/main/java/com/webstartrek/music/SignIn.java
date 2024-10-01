package com.webstartrek.music;

import lombok.Data;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Named
@RequestScoped
public class SignIn {

    @Inject
    private UserManager userManager;

    @Pattern(regexp = "[A-Za-z0-9]{2,20}", message = "Please enter a username consisting of only letters and digits, between 2 and 20 characters long.")
    private String username;

    @Size(min = 8, message = "Your password must consist of at least 8 characters.")
    private String password;

    public String submit() {
        return userManager.signIn(username, password);
    }
}