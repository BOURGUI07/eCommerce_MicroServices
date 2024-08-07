/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.client;

import java.util.List;
import lombok.RequiredArgsConstructor;
import main.dtos.PurchaseRequest;
import main.dtos.PurchaseResponse;
import main.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author hp
 */
@Service
@RequiredArgsConstructor
public class ProductClient {
    @Value("${application.config.product-url}")
    private String productUrl;
    private final RestTemplate rest;
    
    public List<PurchaseResponse> purchaseProducts(@RequestBody List<PurchaseRequest> requests){
        var headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<List<PurchaseRequest>> requestEntity = new HttpEntity<>(requests,headers);
        ParameterizedTypeReference<List<PurchaseResponse>> responseType = new ParameterizedTypeReference<>(){};
        ResponseEntity<List<PurchaseResponse>> responseEntity = rest.exchange(
                productUrl+"/purchase",
                HttpMethod.POST,
                requestEntity,
                responseType);
        if(responseEntity.getStatusCode().isError()){
            throw new BusinessException("An Error Occured While Processing The Products Purchase" + responseEntity.getStatusCode());
        }
        return responseEntity.getBody();
    }
}
