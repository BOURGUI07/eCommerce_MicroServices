/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import main.dto.ProductPurchaseRequest;
import main.dto.ProductPurchaseResponse;
import main.dto.ProductRequest;
import main.dto.ProductResponse;
import main.exception.ProductNotFoundException;
import main.exception.ProductPurchaseException;
import main.repo.CategoryRepo;
import main.repo.ProductRepo;
import main.util.ProductMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@RequiredArgsConstructor
public class ProductService {
     private final ProductRepo repo;
     private final CategoryRepo categRepo;
    private final ProductMapper mapper;
    
    
    public Integer create(ProductRequest x){
        var product = mapper.toEntity(x);
        var savedProduct = repo.save(product);
        return savedProduct.getId();
    }
    
    public void update(Integer id, ProductRequest x){
        var p  = repo.findById(id).orElseThrow(
                () -> new ProductNotFoundException("product with id: " + id + " isn't found")
        );
        p.setDescription(x.description());
        p.setName(x.name());
        p.setQuantity(x.quantity());
        p.setPrice(x.price());
        categRepo.findById(x.categoryId()).ifPresent(p::setCategory);
        repo.save(p);  
        
    }
    
    public List<ProductResponse> findAll(){
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }
    
    public List<ProductPurchaseResponse> purchase(List<ProductPurchaseRequest> list){
        var idList = list.stream().map(x -> x.id()).collect(Collectors.toList());
        var products = repo.findAllById(idList);
        if(products.size()!=idList.size()){
            throw new ProductPurchaseException("At least One Product doesn't exists");
        }else{
            var requestedQty = list.stream()
                                .mapToInt(x -> x.quantity())
                                .sum();
            var availableQty = products.stream()
                                .mapToInt(x -> x.getQuantity())
                                .sum();
            if(requestedQty<=availableQty){
                var map = list
                        .stream()
                        .collect(Collectors.toMap(ProductPurchaseRequest::id, ProductPurchaseRequest::quantity));
                map.keySet().stream().forEach(idd -> repo.findById(idd).get().setQuantity(repo.findById(idd).get().getQuantity()-map.get(idd)));
                repo.saveAll(products);
                
                return products.stream().map(mapper::toPurchaseResponse).toList();
            }else{
                throw new ProductPurchaseException("At least One Product Quantity exceeds stored product inventoiry");
            }
        }
        
    }

    public Boolean existsById(Integer id){
        return repo.existsById(id);
    }    
    
    public ProductResponse findById(Integer id){
        var product  = repo.findById(id).orElseThrow(
                () -> new ProductNotFoundException("product with id: " + id + " isn't found")
        );
        return mapper.toDTO(product);
    }
    
    public void delete(Integer id){
        repo.deleteById(id);
    }
}
