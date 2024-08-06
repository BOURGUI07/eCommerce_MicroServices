/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.dto;

import java.math.BigDecimal;

/**
 *
 * @author hp
 */
public record ProductResponse(
         Integer id,
         String name,
    
         String description,
         
         Integer quantity,
    
         BigDecimal price,
         
         Integer categoryId,
         
         String categoryName,
         
         String categoryDesc
        ) {
    
}
