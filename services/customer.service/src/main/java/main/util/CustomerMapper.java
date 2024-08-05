/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.util;

import main.dtos.CustomerRequest;
import main.dtos.CustomerResponse;
import main.model.Customer;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class CustomerMapper {
    public Customer toEntity(CustomerRequest x){
        if(x==null){
            return null;
        }
        var customer = new Customer();
        customer.setAddress(x.address());
        customer.setEmail(x.email());
        customer.setFirstname(x.firstname());
        customer.setLastname(x.lastname());
        return customer;
    } 
    
    public CustomerResponse toDTO(Customer c){
        return new CustomerResponse(c.getId(),c.getFirstname(),c.getLastname(),c.getEmail(),c.getAddress());
    }
}
