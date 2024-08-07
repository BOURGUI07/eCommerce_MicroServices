/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package main.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 *
 * @author hp
 */
public record PurchaseRequest(
            @NotNull(message="product is mandatory")
            Integer productId,
            @Positive(message="quantity should be positive")
            Integer quantity
        ) {

}
