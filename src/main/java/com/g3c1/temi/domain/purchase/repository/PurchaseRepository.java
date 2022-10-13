package com.g3c1.temi.domain.purchase.repository;

import com.g3c1.temi.domain.purchase.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface PurchaseRepository extends CrudRepository<Purchase,Long> {
}
