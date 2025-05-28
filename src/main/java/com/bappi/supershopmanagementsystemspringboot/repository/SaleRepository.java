package com.bappi.supershopmanagementsystemspringboot.repository;

import com.bappi.supershopmanagementsystemspringboot.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
