package com.webstartrek.music;

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

    @Getter
    private User user;

    public void onload() {
        user = userManager.isSignedIn() ? userManager.getCurrentUser() : new User();
    }

    public String submit() {
        return userManager.save(user);
    }

    public void validateEmail(FacesContext context, UIComponent component, Object value) {
        String emailAddress = (String) value;
        if (emailAddress != null && !emailAddress.isEmpty() && !emailAddress.contains("@")) {
            throw new ValidatorException(new FacesMessage("Please enter a valid e-mail address."));
        }
    }
}