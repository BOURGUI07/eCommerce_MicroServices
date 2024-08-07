/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;
import main.model.PaymentMethod;

/**
 *
 * @author hp
 */
public record OrderRequest(
        Integer id,
        String reference,
        @Positive(message="order amount should be positive")
        BigDecimal total,
        @NotNull(message="payment method required")
        PaymentMethod method,
        @NotNull(message="customer required")
        @NotBlank(message="customer required")
        String customerId,
        @NotEmpty(message="product list must contain at least one product")
        List<PurchaseRequest> products
        ) {
    
}
