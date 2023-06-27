package com.example.produectservice.service;

import com.example.produectservice.model.Product;
import com.example.produectservice.repository.ProductRepository;
import dto.ProductRequest;
import dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    //We can use @RequiredArgsConstructor annotation instead of creating constructor
    /*
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
     */

    //This is a method that creates a new product based on the information provided in the ProductRequest object.
    // The method uses the Builder pattern to construct a new Product object with the given name, description, and price.
    // Once the product is created, it is saved to the product repository using the save() method.
    // Finally, a log message is generated to confirm that the product has been saved successfully.
    // This method is useful for adding new products to the system and can be called from other parts of the application.
    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        //log.info("Product " + product.getId() + " is saved");
        log.info("Product {} is saved" , product.getId());
    }

    // This code retrieves all products from the product repository and maps each product to a product response using the mapToProductResponse method.
    // The resulting list of product responses is then returned.
    public List<ProductResponse> getAllProducts() {
       List<Product> products = productRepository.findAll();

       return products.stream().map(this::mapToProductResponse).toList();
    }

    // This is a method that maps a Product object to a ProductResponse object.
    // It takes in a Product object as a parameter and returns a ProductResponse object.
    // The method uses the builder pattern to set the values of the ProductResponse object's fields based on the values of the corresponding fields in the Product object.
    // The method sets the id, name, description, and price fields of the ProductResponse object and then returns it.
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
