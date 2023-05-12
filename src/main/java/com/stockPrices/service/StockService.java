package com.stockPrices.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stockPrices.entity.StockEntity;

@Service
@Component
public interface StockService {

	public List<StockEntity> getAllStocks();

}
