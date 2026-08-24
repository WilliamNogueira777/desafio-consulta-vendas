package com.devsuperior.dsmeta.dto;

import com.devsuperior.dsmeta.entities.Seller;

import java.util.List;

public class SellerMinDTO {

    private String sellerName;
    private Double total;

    public SellerMinDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public String getSellerName() {
        return sellerName;
    }

    public Double getTotal() {
        return total;
    }
}
