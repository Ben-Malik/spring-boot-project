package com.bao.baoltd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bao.baoltd.model.Exchange;
import com.bao.baoltd.repository.ExchangeRepository;

@Component
@Service
@Transactional
public class ExchangeManagerImpl implements ExchangeManager{

	@Autowired
	private ExchangeRepository repository;
	
	@Override
	public List<Exchange> getAllExchanges() {
		return repository.findAll();
	}

	@Override
	public Optional<Exchange> getById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Exchange create(Exchange exchange) {
		return repository.save(exchange);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public Optional<Exchange> getByName(String name) {
		return repository.findByName(name);
	}

}
