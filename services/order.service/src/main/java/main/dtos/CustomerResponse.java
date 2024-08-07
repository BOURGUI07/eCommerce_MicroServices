/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package main.dtos;

/**
 *
 * @author hp
 */
public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
        ) {

}
