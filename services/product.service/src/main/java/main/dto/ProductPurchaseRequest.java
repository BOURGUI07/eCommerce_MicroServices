/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package main.dto;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author hp
 */
public record ProductPurchaseRequest(
            @NotNull(message="Product id required")
            Integer id,
            @NotNull(message="quantity is mandatory")
            Integer quantity
        ) {
}
