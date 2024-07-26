package com.codegym.gio_hang.services;

import com.codegym.gio_hang.models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);


}
