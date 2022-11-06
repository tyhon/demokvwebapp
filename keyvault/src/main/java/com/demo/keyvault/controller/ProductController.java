package com.demo.keyvault.controller;


import com.demo.keyvault.entity.Product;
import com.demo.keyvault.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> products = productService.getProducts();
        return products;
    }

    @PostMapping("/product")
    public ResponseEntity addProduct(@RequestBody Product product){
        String success = productService.addProduct(product);
        return new ResponseEntity(success, HttpStatus.CREATED);
    }

    @PutMapping("/product")
    public ResponseEntity updateProduct(@RequestBody Product product){
        String success = productService.updateProduct(product);
        return new ResponseEntity(success, HttpStatus.OK);
    }

    @DeleteMapping("/product")
    public ResponseEntity deleteProduct(@RequestParam Integer id){
        String success = productService.deleteProduct(id);
        return new ResponseEntity(success, HttpStatus.OK);
    }

}
