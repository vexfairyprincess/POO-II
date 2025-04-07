package org.samm.s6w3.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1, max = 100, message = "Name must be between 1 and 100 characters.")
    private String name;

    @Size(max = 255, message = "Description can't exceed 255 characters.")
    private String description;

    @Positive(message = "Price must be a positive number.")
    private Double price;

    @Min(value = 0, message = "Quantity cannot be negative.")
    private Integer quantity;

    @Size(max = 50, message = "Category can't exceed 50 characters.")
    private String category;
}