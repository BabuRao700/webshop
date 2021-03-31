package com.webshop.productservice;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("welcome", HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<String> getAllProducts() {
        List<Product> products = this.productService.getAllProducts();
        return new ResponseEntity<>(getJson(products), HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<String> findProductById(@PathVariable Integer id) {
        List<Product> products = this.productService.getProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        this.productService.createProduct(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody List<Product> products) {
        this.productService.createProducts(products);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private String getJson(List<Product> products) {
        return new Gson().toJson(products);
    }

}
