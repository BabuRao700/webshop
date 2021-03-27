package com.webshop.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public List<Product> getProductById(Integer id) {
        return this.productRepository.findAllById(new ArrayList<>(Arrays.asList(id)));
    }

    public void createProduct(Product product) {
        this.productRepository.save(product);
    }

    public void createProducts(List<Product> products) {
        this.productRepository.saveAll(products);
    }
}
