package com.bappi.supershopmanagementsystemspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "saleDetails")
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SaleDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="saleId")
    private Sale sale;

    @ManyToOne
    @JoinColumn(name="productId")
    private Product product;

    @Column(name="unitPrice")
    private Double unitPrice;

    private Integer quantity;

    private Double price;

}
