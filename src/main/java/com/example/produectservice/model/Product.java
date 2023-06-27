package com.example.produectservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

//This is a Java class representing a product.
// It is annotated with "@Document" to indicate that it will be stored in a document-based database.
// The value of the annotation is "product," which is the name of the collection in which the documents will be stored.
// The class has four fields: 1. "id" (a unique identifier for the product),
//                            2. "name" (the name of the product),
//                            3. "description" (a brief description of the product),
//                            and 4. "price" (the price of the product).
// The class also has the "@AllArgsConstructor", "@NoArgsConstructor", "@Builder", and "@Data" annotations to provide constructors, builder methods, and getters and setters for the fields.

@Document(value = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
