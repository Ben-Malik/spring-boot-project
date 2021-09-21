package com.bao.baoltd.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bao.baoltd.model.User;

@Repository("UserRepository")
public interface UserRepository extends CrudRepository<User, Long> {

	@EntityGraph(value = "UserComplete", type=EntityGraphType.FETCH)
	User findByUsername(String username);
			
	User findByEmail(String email);
}
