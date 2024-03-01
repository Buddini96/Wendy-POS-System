package com.wendy.backend.controller;

import com.wendy.backend.exception.ProductNotFoundException;
import com.wendy.backend.model.Product;
import com.wendy.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Buddini
 * Created on 01 Mar, 2024
 */

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/product")
    Product newProduct(@RequestBody Product newProduct){
        return productRepository.save(newProduct);
    }

    @GetMapping("/product")
    List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    Product getProductById(@PathVariable Integer id){
        return productRepository.findById(id)
                .orElseThrow(() ->new ProductNotFoundException(id));
    }

    @PutMapping("/product/{id}")
    Product updateProduct(@RequestBody Product newProduct, @PathVariable Integer id){
        return productRepository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setCategory(newProduct.getCategory());
                    product.setQty(newProduct.getQty());
                    product.setPrice(newProduct.getPrice());
                    return productRepository.save(product);
                }).orElseThrow(() ->new ProductNotFoundException(id));
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        try {
            productRepository.deleteById(id);
            return "Product with id " + id + " has been deleted successfully";
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            return "Error deleting product with id " + id;
        }
    }


}
