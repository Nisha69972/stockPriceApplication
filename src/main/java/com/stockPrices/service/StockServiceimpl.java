package com.stockPrices.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.stockPrices.entity.StockEntity;
import com.stockPrices.repository.StockRepository;

@Service
public class StockServiceimpl implements StockService {

	@Autowired
	StockRepository stockRepo;

	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;

	@Override
	public List<StockEntity> getAllStocks() {

		return stockRepo.findAll();
	}

	@Scheduled(fixedDelay = 3000)
	public void updatedPrice() {
		simpMessagingTemplate.convertAndSend("/topic/stocks", stockRepo.findAll());
	}

	@Scheduled(fixedRate = 7000)
	public void updateAppleStockPrice() {

		Optional<StockEntity> stockOptional = stockRepo.findByName("Apple");

		if (stockOptional.isPresent()) {
			StockEntity stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepo.save(stock);
		}
	}

	@Scheduled(fixedRate = 6000)
	public void updateIBMStockPrice() {
		Optional<StockEntity> stockOptional = stockRepo.findByName("IBM");
		if (stockOptional.isPresent()) {
			StockEntity stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepo.save(stock);

		}
	}

	@Scheduled(fixedRate = 2000)
	public void updateInfosysStockPrice() {
		Optional<StockEntity> stockOptional = stockRepo.findByName("Infosys");
		if (stockOptional.isPresent()) {
			StockEntity stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepo.save(stock);

		}
	}

	@Scheduled(fixedRate = 1000)
	public void updateRelianceStockPrice() {

		Optional<StockEntity> stockOptional = stockRepo.findByName("Reliance");
		if (stockOptional.isPresent()) {
			StockEntity stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepo.save(stock);
		}
	}

	@Scheduled(fixedRate = 5000)
	public void updateZensarStockPrice() {
		Optional<StockEntity> stockOptional = stockRepo.findByName("Zensar");
		if (stockOptional.isPresent()) {
			StockEntity stock = stockOptional.get();
			int newPrice = generateRandomPrice();
			stock.setPrice(newPrice);
			stockRepo.save(stock);
		}
	}

	/*
	 * @Scheduled(fixedDelay = 3000 ) public void updatedPrice() {
	 * simpMessagingTemplate.convertAndSend("/topic/stocks", stockRepo.findAll()); }
	 */

	private int generateRandomPrice() {
		Random random = new Random();
		int minPrice = 100;
		int maxPrice = 200;
		return random.nextInt((maxPrice - minPrice) + 1) + minPrice;
		// return minPrice + (maxPrice - minPrice) * random.nextInt();
	}

}
