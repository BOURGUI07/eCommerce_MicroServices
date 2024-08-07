/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.util;

import lombok.RequiredArgsConstructor;
import main.dtos.OrderRequest;
import main.model.Order;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@RequiredArgsConstructor
public class OrderMapper {
    public Order toEntity(OrderRequest x){
        var o = new Order();
        o.setCustomerId(x.customerId());
        o.setPaymentMethod(x.method());
        o.setTotal(x.total());
        o.setReference(x.reference());
        return o;
    }
}
