package com.example.payuClient.model;

import lombok.*;
import java.util.List;

@Setter
@Getter
public class OrderRequest {

    private String notifyUrl;
    private String customerIp;
    private String merchantPosId;
    private String description;
    private String currencyCode;
    private String totalAmount;
    private Buyer buyer;
    private Settings settings;
    private List<Product> products;

    @Builder
    public OrderRequest(String notifyUrl, String customerIp, String merchantPosId, String description, String currencyCode, String totalAmount) {
        this.notifyUrl = notifyUrl;
        this.customerIp = customerIp;
        this.merchantPosId = merchantPosId;
        this.description = description;
        this.currencyCode = currencyCode;
        this.totalAmount = totalAmount;
    }

    public void setProducts(List<Product> products) {
        int total = 0;
        for (Product p : products){
            total += Integer.parseInt(p.getUnitPrice());
        }
        this.totalAmount = Integer.toString(total);
        this.products = products;
    }
}
