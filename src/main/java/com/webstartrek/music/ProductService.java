package com.webstartrek.music;

import com.webstartrek.music.models.Product;

import java.util.List;

public interface ProductService {

    List<Product> getPopularProducts();

    Product getProduct(long id);
}
