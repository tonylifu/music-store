package com.webstartrek.music.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    private String areaCode;
    private String officeCode;
    private String subscriberNumber;

}