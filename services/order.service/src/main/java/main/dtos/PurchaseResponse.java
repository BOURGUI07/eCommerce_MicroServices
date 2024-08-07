/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package main.dtos;

import java.math.BigDecimal;

/**
 *
 * @author hp
 */
public record PurchaseResponse(
            Integer productId,
            String name,
            Integer quantity,
            BigDecimal price
            
        ) {

}
