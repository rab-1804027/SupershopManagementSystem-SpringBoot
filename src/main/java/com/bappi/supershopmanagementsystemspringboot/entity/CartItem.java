package com.bappi.supershopmanagementsystemspringboot.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private Product product;
    private int quantity;
    private double price;


    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.price = product.getPrice() * quantity;
    }

}
