/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import main.dto.ProductPurchaseRequest;
import main.dto.ProductPurchaseResponse;
import main.dto.ProductRequest;
import main.dto.ProductResponse;
import main.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("/api/v1/products")
@Validated
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    
    @PostMapping
    public ResponseEntity<Integer> createCustomer(@RequestBody @Valid ProductRequest customer){
        var id = service.create(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }
    
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request
    ){
        return ResponseEntity.ok(service.purchase(request));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(
            @PathVariable Integer id,
            @Valid @RequestBody ProductRequest x){
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll()); 
    }
    
    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(service.existsById(id)); 
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(id)); 
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
