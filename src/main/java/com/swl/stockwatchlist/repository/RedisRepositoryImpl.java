package com.swl.stockwatchlist.repository;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.swl.stockwatchlist.domain.Stock;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
	
	private RedisTemplate<String, Stock> redistemplate;
	
	private HashOperations hashOperations;
	

	public RedisRepositoryImpl(RedisTemplate<String, Stock> redistemplate) {
		this.redistemplate = redistemplate;
		hashOperations = redistemplate.opsForHash();
	}

	@Override
	public void save(Stock stock) {
		hashOperations.put("STOCK", stock.getId(), stock);
	}

	@Override
	public Map<String, Stock> findAll() {
		return hashOperations.entries("STOCK");
	}

	@Override
	public Stock findById(String id) {
		return (Stock)hashOperations.get("STOCK", id);
	}

	@Override
	public void update(Stock stock) {
		save(stock);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete("STOCK", id);
	}

}
