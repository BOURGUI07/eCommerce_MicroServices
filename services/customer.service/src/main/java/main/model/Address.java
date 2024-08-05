/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author hp
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
@Validated
public class Address {
    private String street;
    private String houseNumber;
    private String zipCode;
}
