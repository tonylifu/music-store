package com.webstartrek.music;

import com.webstartrek.music.annotations.ValidEmailAddress;
import com.webstartrek.music.annotations.ValidPhoneNumber;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Pattern(regexp = "[A-Za-z0-9]{2,20}", message = "Please enter a username consisting of only letters and digits, between 2 and 20 characters long.")
    private String username;

    @Size(min = 8, message = "Your password must consist of at least 8 characters.")
    private String password;

    @Size(min = 1, max = 30, message = "Please enter a first name between 1 and 30 characters long.")
    private String firstName;

    @Size(min = 1, max = 30, message = "Please enter a last name between 1 and 30 characters long.")
    private String lastName;

    @ValidEmailAddress
    private String emailAddress;

    @ValidPhoneNumber
    private String phoneNumber;

    @Past(message = "Your birth date must be in the past.")
    private Date birthDate;

    @NotNull(message = "Please indicate if you want to subscribe to the newsletter or not.")
    private Boolean subscribedToNewsletter;
}
