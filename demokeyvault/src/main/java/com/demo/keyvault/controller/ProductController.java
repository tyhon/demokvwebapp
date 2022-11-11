package com.demo.keyvault.controller;


import com.demo.keyvault.ProductRepository;
import com.demo.keyvault.entity.Product;
import com.demo.keyvault.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class ProductController {

    private ProductService productService;
    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository){
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        List<Product> products = productService.getProducts();
        return products;
    }

    @GetMapping()
    public String listProducts(Model model){
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/add")
    public String addNew(Product product){
        return "add-product";
    }



    @PostMapping("/addProduct")
    public String addProduct(@Valid Product product, BindingResult result){
        if (result.hasErrors()){
            return "add-product";
        }
//        String success = productService.addProduct(product);
        productRepository.save(product);
        return "redirect:/";
//        return new ResponseEntity(success, HttpStatus.CREATED);
    }

    @GetMapping("/edit/{id}")
    public String updateForm(@PathVariable("id") Integer id, Model model){
        Product product = productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid id: "+id));
        model.addAttribute("product", product);
        return "update-product";
    }

    @PostMapping("/product/{id}")
    public String updateProduct(@PathVariable("id") Integer id,@Valid Product product, BindingResult result){
//        String success = productService.updateProduct(product);
//        return new ResponseEntity(success, HttpStatus.OK);
        if (result.hasErrors()){
            product.setId(id);
            return "update-product";
        }
        productRepository.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        Product product = productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid id: "+id));
//        String success = productService.deleteProduct(id);
        productRepository.delete(product);
        return "redirect:/";
    }

}