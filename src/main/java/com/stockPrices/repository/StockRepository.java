package com.stockPrices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockPrices.entity.StockEntity;

public interface StockRepository extends JpaRepository<StockEntity, Integer> {

	Optional<StockEntity> findByName(String string);
}
