/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author hp
 */
@Entity
@Table(name="orders")
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Order {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    
    @Column(name="reference")
    private String reference;
    
    
    private BigDecimal total;
    
    
    @Enumerated(EnumType.STRING)
    @Column(name="reference")
    private PaymentMethod paymentMethod;
    
    
    private String customerId;
    
    
    
    @OneToMany(mappedBy="order", cascade=CascadeType.ALL,orphanRemoval=true)
    @JsonManagedReference
    private List<OrderLine> orderLines = new ArrayList<>();
    
    
    @CreatedDate
    @Column(updatable=false, nullable=false)
    private LocalDateTime createdAt;
    
    
    @LastModifiedDate
    @Column(insertable=false, nullable=true)
    private LocalDateTime lastModifiedDate;
}
