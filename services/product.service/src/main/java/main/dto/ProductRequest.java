/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 *
 * @author hp
 */
public record ProductRequest(
         Integer id,
        @NotNull(message="product name is required")
         String name,
    
         String description,
         
         @NotNull(message="product quantity is required")
         @Positive(message="Product quantity must be positive")
         Integer quantity,
    
         @NotNull(message="product price is required")
         @Positive(message="Product price must be positive")
         BigDecimal price,
         
         Integer categoryId
        ) {
    
}
