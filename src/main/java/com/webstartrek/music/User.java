package com.webstartrek.music;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private Date birthDate;
    private Boolean subscribedToNewsletter;
}
