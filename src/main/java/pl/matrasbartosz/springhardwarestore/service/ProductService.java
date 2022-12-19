package pl.matrasbartosz.springhardwarestore.service;

import pl.matrasbartosz.springhardwarestore.entity.Product;

public interface ProductService {

    Product findProductById(Long id);

    void save(Product product);
}
