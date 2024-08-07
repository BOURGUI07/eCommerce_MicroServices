/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package main.dtos;

import java.math.BigDecimal;
import java.util.List;
import main.model.PaymentMethod;

/**
 *
 * @author hp
 */
public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod method,
        CustomerResponse customer,
        List<PurchaseResponse> products
        ) {

}
