/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main.repo;

import main.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author hp
 */
public interface CustomerRepo extends MongoRepository<Customer,String> {
    
}
