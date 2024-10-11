package com.webstartrek.music;

import com.webstartrek.music.models.User;
import lombok.Getter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class UserDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UserManager userManager;

    private User user;

    public User getUser() {
        return user;
    }

    public void onload() {
        user = userManager.isSignedIn() ? userManager.getCurrentUser() : new User();
    }

    public String submit() {
        return userManager.save(user);
    }
}