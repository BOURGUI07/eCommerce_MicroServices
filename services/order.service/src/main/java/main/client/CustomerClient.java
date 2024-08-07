/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package main.client;

import java.util.Optional;
import main.dtos.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author hp
 */
@FeignClient(name= "customer-service",
             url = "${application.config.customer-url}"   )
public interface CustomerClient {
    @GetMapping("/{id}")
    Optional<CustomerResponse> findCustomerById(
            @PathVariable String id
    );
}
