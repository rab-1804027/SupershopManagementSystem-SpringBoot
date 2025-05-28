package com.bappi.supershopmanagementsystemspringboot.repository;

import com.bappi.supershopmanagementsystemspringboot.entity.SaleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailsRepository extends JpaRepository<SaleDetails, Integer> {

}
