/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.util;

import lombok.RequiredArgsConstructor;
import main.dtos.OrderLineRequest;
import main.model.OrderLine;
import main.repo.OrderRepo;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@RequiredArgsConstructor
public class OrderLineMapper {
    private final OrderRepo repo;
    public OrderLine toEntity(OrderLineRequest x){
        var o = new OrderLine();
        repo.findById(x.orderId()).ifPresent(o::setOrder);
        o.setProductId(x.productId());
        o.setQuantity(x.quantity());
        return o;
    }
}
