package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import com.bao.baoltd.model.Exchange;

public interface ExchangeManager {
	
	List<Exchange> getAllExchanges();

    Optional<Exchange> getById(Long id);
    
    Exchange create(Exchange exchange);
    
    Optional<Exchange> getByName(String name);

    void deleteById(Long id);
    

}
