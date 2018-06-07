package com.example.payuClient.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Product {

    private String name;
    private String unitPrice;
    private String quantity;

    public Product(String name, String unitPrice, String quantity) {
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
}
