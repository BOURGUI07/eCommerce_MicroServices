/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package main.dto;

import java.math.BigDecimal;

/**
 *
 * @author hp
 */
public record ProductPurchaseResponse(
        Integer id,
        String name,
        String desc,
        BigDecimal price,
        Integer quantity
        ) {

}
