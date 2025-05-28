package com.bappi.supershopmanagementsystemspringboot.controller;

import com.bappi.supershopmanagementsystemspringboot.dto.AddToCartRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.CartItem;
import com.bappi.supershopmanagementsystemspringboot.entity.Product;
import com.bappi.supershopmanagementsystemspringboot.entity.Sale;
import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.service.ProductCartService;
import com.bappi.supershopmanagementsystemspringboot.service.ProductService;
import com.bappi.supershopmanagementsystemspringboot.service.SaleService;
import com.bappi.supershopmanagementsystemspringboot.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@Slf4j
public class CartController {

    private final ProductService productService;
    private final ProductCartService cart;
    private final UserService userService;
    private final SaleService saleService;
   // private final ModelMapper modelMapper;

    public CartController(ProductService productService, ProductCartService cart, UserService userService, SaleService saleService) {
        this.productService = productService;
        this.cart = cart;
        this.userService = userService;
        this.saleService = saleService;
        cart.initCart();
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

        cart.add(cartItem);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Product added to cart successfully!");
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> removeFromCart(@PathVariable("id") Integer id){
        cart.removeById(id);

        return ResponseEntity
                .ok("Product removed from cart successfully!");
    }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByUsername(username);
        Double totalPrice = cart.getTotalPrice();

        Sale sale = saleService.save(user, totalPrice);
        log.info("Sale saved with id: {}", sale.getId());

        return ResponseEntity
                .ok("Checkout successful!");
    }
}
