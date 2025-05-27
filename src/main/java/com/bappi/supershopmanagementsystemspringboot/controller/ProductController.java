package com.bappi.supershopmanagementsystemspringboot.controller;

import com.bappi.supershopmanagementsystemspringboot.dto.ProductUpdateRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.Product;
import com.bappi.supershopmanagementsystemspringboot.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody Product product){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        productService.save(username, product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable("id") Integer id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){

        productService.update(id, productUpdateRequestDto);

        return null;
    }
}
