/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import main.dtos.OrderConfirmation;
import org.springframework.stereotype.Service;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

/**
 *
 * @author hp
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderProducer {
    
    private final KafkaTemplate<String, OrderConfirmation> template;
    public void sendOrderConfirmation(OrderConfirmation o){
        log.info("Sending order confirmation");
        Message<OrderConfirmation> message = MessageBuilder()
                .withPayload(OrderConfirmation)
                .setHeader(KafkaHeaders.TOPIC,"order-topic").build();
        template.send(message);
    }
}
