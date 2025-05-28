package com.bappi.supershopmanagementsystemspringboot.service;

import com.bappi.supershopmanagementsystemspringboot.dto.ProductCreateRequestDto;
import com.bappi.supershopmanagementsystemspringboot.dto.ProductUpdateRequestDto;
import com.bappi.supershopmanagementsystemspringboot.entity.Product;
import com.bappi.supershopmanagementsystemspringboot.entity.User;
import com.bappi.supershopmanagementsystemspringboot.mapper.UserMapper;
import com.bappi.supershopmanagementsystemspringboot.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserService userService;
    private final ModelMapper modelMapper;

    public void save(String username, ProductCreateRequestDto productCreateRequestDto){

        Product product = modelMapper.map(productCreateRequestDto, Product.class);
        User user = userService.findByUsername(username);
        product.setUser(user);

        productRepository.save(product);
    }

    public void update(Integer id, ProductUpdateRequestDto productUpdateRequestDto){
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent()){

            if(productUpdateRequestDto.getName() != null)
                product.get().setName(productUpdateRequestDto.getName());
            if(productUpdateRequestDto.getPrice() != null)
                product.get().setPrice(productUpdateRequestDto.getPrice());
            if(productUpdateRequestDto.getStockQuantity() != null)
                product.get().setStockQuantity(productUpdateRequestDto.getStockQuantity());

            productRepository.save(product.get());
        }
    }

    public Product findById(Integer id){
        return productRepository
                .findById(id)
                .orElse(null);
    }
}
