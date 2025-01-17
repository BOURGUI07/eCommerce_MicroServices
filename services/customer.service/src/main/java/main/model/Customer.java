/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author hp
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Customer {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}
