/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import main.client.CustomerClient;
import main.client.ProductClient;
import main.dtos.OrderConfirmation;
import main.dtos.OrderLineRequest;
import main.dtos.OrderRequest;
import main.exception.BusinessException;
import main.kafka.OrderProducer;
import main.repo.OrderRepo;
import main.util.OrderMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepo repo;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderLineService lineService;
    private final OrderProducer producer;
    
      public Integer create(OrderRequest x){
        var customer = customerClient.findCustomerById(x.customerId())
                .orElseThrow(() -> new BusinessException("Customer isn't found"));
        var purchasedProducts = productClient.purchaseProducts(x.products());
        var order = repo.save(mapper.toEntity(x));
        for(var request:x.products()){
            lineService.saveOrderLine(
                    new OrderLineRequest(null, order.getId(),request.productId(), request.quantity())
            );
        }
        // todo!! start payment Process
        producer.sendOrderConfirmation(new OrderConfirmation(
                x.reference(),
                x.total(),
                x.method(),
                customer,
                purchasedProducts
        ));
        
        return order.getId();
    }
 
}
