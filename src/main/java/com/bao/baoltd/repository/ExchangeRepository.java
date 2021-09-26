package com.bao.baoltd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bao.baoltd.model.Exchange;

/**
 * 
 * @author ben-maliktchamalam
 *
 */
@Repository("ExchangeRepository")
public interface ExchangeRepository extends JpaRepository<Exchange, Long>, JpaSpecificationExecutor<Exchange>{

	List<Exchange> findByName(String name);

}
