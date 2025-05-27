package com.bappi.supershopmanagementsystemspringboot.service;

import com.bappi.supershopmanagementsystemspringboot.dto.ProductUpdateRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.Product;
import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;

    public void save(String username, Product product){
        User user = userService.findByUsername(username);
        product.setUser(user);
        productRepository.save(product);
    }

    public void update(Integer id, ProductUpdateRequestDto productUpdateRequestDto){
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){
            if(!productUpdateRequestDto.getName().isEmpty())
                product.get().setName(productUpdateRequestDto.getName());
            System.out.println(productUpdateRequestDto.getName());
            productRepository.save(product.get());
        }
    }
}
