package com.stockPrices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockPrices.entity.StockEntity;
import com.stockPrices.service.StockService;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping(value = "/stockApp")
public class StockController {

	@Autowired
	StockService stockService;

	@GetMapping("/stocks")
	@SendTo("/topic/stocks") 
	//@GetMapping(value="/stocks ", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockEntity> getAllStocks() {
		return stockService.getAllStocks();
	}

	
	
	
	
	
	
	
	/*
	 * @MessageMapping("/stocks")
	 * 
	 * @SendTo("/topic/stocks") public ResponseEntity<List<StockEntity>>
	 * getAllStocks() { List<StockEntity> stocks = stockService.getAllStocks();
	 * return new ResponseEntity<>(stocks, HttpStatus.OK); }
	 */

	
}
