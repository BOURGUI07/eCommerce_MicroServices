/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.util;

import lombok.RequiredArgsConstructor;
import main.dto.ProductPurchaseResponse;
import main.dto.ProductRequest;
import main.dto.ProductResponse;
import main.model.Product;
import main.repo.CategoryRepo;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryRepo repo;
    public Product toEntity(ProductRequest x){
        var p = new Product();
        p.setDescription(x.description());
        p.setName(x.name());
        p.setQuantity(x.quantity());
        p.setPrice(x.price());
        repo.findById(x.categoryId()).ifPresent(p::setCategory);
        return p;
    }
    
    public ProductResponse toDTO(Product p){
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getQuantity(),
                p.getPrice(),
                p.getCategory().getId(),
                p.getCategory().getName(),
                p.getCategory().getDescription()
        );
    }
    
    public ProductPurchaseResponse toPurchaseResponse(Product p){
        return new ProductPurchaseResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getPrice(),
                p.getQuantity()       
        );
    }
}
