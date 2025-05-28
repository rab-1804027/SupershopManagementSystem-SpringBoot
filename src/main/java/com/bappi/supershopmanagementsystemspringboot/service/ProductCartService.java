package com.bappi.supershopmanagementsystemspringboot.service;

import com.bappi.supershopmanagementsystemspringboot.entity.CartItem;
import com.bappi.supershopmanagementsystemspringboot.entity.Product;
import com.bappi.supershopmanagementsystemspringboot.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
@Data
@RequiredArgsConstructor
public class ProductCartService {

    private final ProductRepository productRepository;

    private List<CartItem> cartItems;
    private double totalPrice;

    public void initCart() {
        cartItems = new ArrayList<>();
        totalPrice = 0;
    }

    public void clearCart() {
        cartItems.clear();
        totalPrice = 0;
    }

    public void add(CartItem cartItem) {
        for (CartItem item : cartItems) {
            if (Objects.equals(item.getProduct().getId(), cartItem.getProduct().getId())) {
                totalPrice = totalPrice - item.getPrice();
                item.setQuantity(item.getQuantity() + cartItem.getQuantity());
                totalPrice = totalPrice + item.getPrice();

                Product product = item.getProduct();
                product.setStockQuantity(product.getStockQuantity() - cartItem.getQuantity());
                productRepository.save(product);
                return;
            }
        }

        cartItems.add(cartItem);
        totalPrice = totalPrice + cartItem.getPrice();

        Product product = cartItem.getProduct();
        product.setStockQuantity(product.getStockQuantity() - cartItem.getQuantity());
        productRepository.save(product);
    }

    public void removeById(int id){
        for(CartItem item : cartItems){
            if(Objects.equals(item.getProduct().getId(), id))
            {
                cartItems.remove(item);
                totalPrice = totalPrice - item.getPrice();

                Product product = item.getProduct();
                product.setStockQuantity(product.getStockQuantity() + item.getQuantity());
                productRepository.save(product);
                return;
            }
        }
    }
}
