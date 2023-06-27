package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

// This is a Java class for a product request.
// It includes the annotation @Data from the Lombok library, which generates getters, setters, equals, hashCode, and toString methods.
// It also includes the @Builder annotation, which generates a builder pattern for creating instances of the class.
// The class has three fields: name, description, and price, all of which are of type String or BigDecimal.
// The class has a constructor with all three fields as parameters, as well as a no-argument constructor.
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
