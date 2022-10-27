package com.g3c1.temi.domain.purchase.domain.repository;

import com.g3c1.temi.domain.purchase.domain.entity.Purchase;
import com.g3c1.temi.domain.seat.domain.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase,Long>, JpaSpecificationExecutor<Purchase> {
    @Query(value = "SELECT purchase FROM Purchase purchase group by purchase.id,purchase.seat,purchase.createdAt,purchase.foodCount,purchase.food order by purchase.createdAt DESC")
    List<Purchase> findAll();
    List<Purchase> findPurchaseBySeat(Seat seat);
}
