package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {


    @Query(value = "SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(obj.id, obj.amount, obj.date, obj.seller.name) " +
            "FROM Sale obj " +
            "WHERE obj.date >= :minDate AND obj.date <= :maxDate " +
            "AND (:sellerName = '' OR LOWER(obj.seller.name) LIKE CONCAT('%', LOWER(:sellerName), '%'))")
    Page<SaleMinDTO> searchReport(LocalDate minDate,
                                  LocalDate maxDate,
                                  String sellerName,
                                  Pageable pageable);

}
