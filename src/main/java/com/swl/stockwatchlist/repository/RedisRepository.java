package com.swl.stockwatchlist.repository;

import java.util.Map;

import com.swl.stockwatchlist.domain.Stock;

public interface RedisRepository {
	
	void save(Stock stock);
	Map<String, Stock> findAll();
	Stock findById(String id);
	void update(Stock stock);
	void delete(String id);

}
