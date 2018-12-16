package com.swl.stockwatchlist.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swl.stockwatchlist.domain.Stock;
import com.swl.stockwatchlist.repository.RedisRepository;

@RestController
@RequestMapping(path = "/api/swl")
public class StockWatchListController {
	private RedisRepository redisrepository;

	public StockWatchListController(RedisRepository redisrepository) {
		super();
		this.redisrepository = redisrepository;
	}
	@GetMapping("/add/{id}/{description}/{date}/{value}")
    public Stock add(@PathVariable("id") final String id,
                    @PathVariable("description") final String description,
                    @PathVariable("date") final String date,
                    @PathVariable("value") final String value) {
        redisrepository.save(new Stock(id, description, date, value));
        return redisrepository.findById(id);
    }
	@GetMapping("/all")
    public Map<String, Stock> all() {
        return redisrepository.findAll();
    }
	
}
