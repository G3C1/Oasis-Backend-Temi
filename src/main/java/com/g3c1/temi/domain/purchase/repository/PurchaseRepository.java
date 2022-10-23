package com.g3c1.temi.domain.purchase.repository;

import com.g3c1.temi.domain.purchase.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long> {
    List<Purchase> findAll();
}
