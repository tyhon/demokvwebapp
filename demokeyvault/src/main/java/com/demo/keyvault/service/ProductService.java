package com.demo.keyvault.service;

import com.demo.keyvault.ProductRepository;
import com.demo.keyvault.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public String addProduct(Product newProduct){
        productRepository.save(newProduct);
        String success = "Added successfully!";
        return success;
    }

    public String updateProduct(Product updatedProduct){
        String success = "Updated successfully";
        Optional<Product> productToFind = productRepository.findById(updatedProduct.getId());
        Product existing = productToFind.get();
        productRepository.save(updatedProduct);
        return success;
    }

    public String deleteProduct(Integer id){
        Optional<Product> productToFind = productRepository.findById(id);
        Product existing = productToFind.get();
        productRepository.delete(existing);
        String success = "Deleted successfully";
        return success;
    }
}