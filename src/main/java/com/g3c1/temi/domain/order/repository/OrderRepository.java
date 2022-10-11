package com.g3c1.temi.domain.order.repository;

import com.g3c1.temi.domain.order.entity.Purchase;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Purchase,Long> {
}
