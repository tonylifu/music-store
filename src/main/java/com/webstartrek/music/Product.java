package com.webstartrek.music;

import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public final class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private final long id;
    private final String name;
    private final String description;
    private final BigDecimal price;
    private final String imageName;

    public Product(long id, String name, String description, BigDecimal price, String imageName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageName = imageName;
    }

    public String getShortDescription() {
        int i = description.indexOf('.');
        if (i >= 0 && i < 100) {
            return description.substring(0, i + 1);
        } else {
            return description.substring(0, Math.min(description.length(), 100)) + "...";
        }
    }

}
