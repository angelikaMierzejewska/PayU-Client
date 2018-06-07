package com.example.payuClient.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderResponse {
    private String orderId;
    private Status status;
    private String redirectUri;
}
