package com.bappi.supershopmanagementsystemspringboot.controller;

import com.bappi.supershopmanagementsystemspringboot.dto.ProductCreateRequestDto;
import com.bappi.supershopmanagementsystemspringboot.dto.ProductUpdateRequestDto;
import com.bappi.supershopmanagementsystemspringboot.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> save(@Valid @RequestBody ProductCreateRequestDto productCreateRequestDto){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        productService.save(username, productCreateRequestDto);
        log.info("Product saved successfully!");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping("/product/{id}")
    public void update(@PathVariable("id") Integer id,@Valid @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        productService.update(id, productUpdateRequestDto);
        log.info("Product updated successfully!");
    }

}
