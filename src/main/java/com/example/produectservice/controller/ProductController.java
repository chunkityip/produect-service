package com.example.produectservice.controller;

import com.example.produectservice.service.ProductService;
import dto.ProductRequest;
import dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // This is a POST endpoint for creating a new product.
    // The @RequestBody annotation indicates that the request body should contain a ProductRequest object.
    // The @ResponseStatus(HttpStatus.CREATED) annotation sets the HTTP status code to 201 (Created) upon successful creation of the product.
    // The createProduct() method in the productService is called to actually create the product.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
       productService.createProduct(productRequest);
    }

    //Check on my notes : Why creating List for gettingAll products

    // This is a GET endpoint that retrieves all products available in the system.
    // It returns a list of ProductResponse objects and has an HTTP status of OK (200).
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }
}

