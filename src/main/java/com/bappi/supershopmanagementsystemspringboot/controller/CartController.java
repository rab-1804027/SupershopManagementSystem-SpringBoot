package com.bappi.supershopmanagementsystemspringboot.controller;

import com.bappi.supershopmanagementsystemspringboot.dto.AddToCartRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.CartItem;
import com.bappi.supershopmanagementsystemspringboot.entity.Product;
import com.bappi.supershopmanagementsystemspringboot.entity.Sale;
import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.service.*;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/cart")
@Slf4j
public class CartController {

    private final ProductService productService;
    private final ProductCartService productCartService;
    private final UserService userService;
    private final SaleService saleService;
    private final SaleDetailsService saleDetailsService;

    public CartController(ProductService productService, ProductCartService productCartService, UserService userService, SaleService saleService, SaleDetailsService saleDetailsService) {
        this.productService = productService;
        this.productCartService = productCartService;
        this.userService = userService;
        this.saleService = saleService;
        this.saleDetailsService = saleDetailsService;
        productCartService.initCart();
    }

    @PostMapping("/product")
    public ResponseEntity<String> addToCart(@Valid @RequestBody AddToCartRequestDto addToCartRequestDto){

        Product product = productService.findById(addToCartRequestDto.getProductId());

        CartItem cartItem =
                CartItem
                        .builder()
                        .product(product)
                        .quantity(addToCartRequestDto.getQuantity())
                        .price(product.getPrice() * addToCartRequestDto.getQuantity())
                        .build();

        productCartService.add(cartItem);
        log.info("Product added to cart successfully! Product id: {}", addToCartRequestDto.getProductId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product added to cart successfully!");
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable("id") Integer id){
        productCartService.removeById(id);
        log.info("Product removed from cart successfully! Product id: {}", id);
        return ResponseEntity
                .ok("Product removed from cart successfully!");
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(Principal principal){
        String username = principal.getName();
        log.info("User {} is checking out", username);
        User user = userService.findByUsername(username);
        Double totalPrice = productCartService.getTotalPrice();

        Sale sale = saleService.save(user, totalPrice);
        log.info("Sale saved with id: {}", sale.getId());

        saleDetailsService.save(sale, productCartService);
        productCartService.clearCart();

        return ResponseEntity
                .ok("Checkout successful!");
    }
}
