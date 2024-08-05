/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import main.model.Address;

/**
 *
 * @author hp
 */
public record CustomerRequest(
     String id,
     @NotNull(message="Customer firstname is required")
     String firstname,
     @NotNull(message="Customer lastname is required")
     String lastname,
     @NotNull(message="Customer email is required")
     @Email(message="Email isn't valid")
     String email,
     Address address
        ) {
    
}
