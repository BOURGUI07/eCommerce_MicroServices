/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import main.dtos.CustomerRequest;
import main.dtos.CustomerResponse;
import main.exception.CustomerNotFoundException;
import main.repo.CustomerRepo;
import main.util.CustomerMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo repo;
    private final CustomerMapper mapper;
    
    
    public String create(CustomerRequest x){
        var customer = mapper.toEntity(x);
        var savedCustomer = repo.save(customer);
        return savedCustomer.getId();
    }
    
    public void update(String id, CustomerRequest x){
        var customer  = repo.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with id: " + id + " isn't found")
        );
        customer.setAddress(x.address());
        customer.setEmail(x.email());
        customer.setFirstname(x.firstname());
        customer.setLastname(x.lastname());
        repo.save(customer);  
        
    }
    
    public List<CustomerResponse> findAll(){
        return repo.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public Boolean existsById(String id){
        return repo.findById(id).isPresent();
    }    
    
    public CustomerResponse findById(String id){
        var customer  = repo.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Customer with id: " + id + " isn't found")
        );
        return mapper.toDTO(customer);
    }
    
    public void delete(String id){
        repo.deleteById(id);
    }
}
