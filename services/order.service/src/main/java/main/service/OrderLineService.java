/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.service;

import lombok.RequiredArgsConstructor;
import main.dtos.OrderLineRequest;
import main.repo.OrderLineRepo;
import main.util.OrderLineMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@RequiredArgsConstructor
@Service
public class OrderLineService {
    private final OrderLineRepo repo;
    private final OrderLineMapper mapper;

    public Integer saveOrderLine(OrderLineRequest orderLineRequest) {
        return repo.save(mapper.toEntity(orderLineRequest)).getId();
    }
    
}
