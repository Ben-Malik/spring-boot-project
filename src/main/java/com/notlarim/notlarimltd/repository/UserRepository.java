package com.notlarim.notlarimltd.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.notlarim.notlarimltd.model.User;

@Repository("UserRepository")
public interface UserRepository extends CrudRepository<User, Long> {

	@EntityGraph(value = "UserComplete", type=EntityGraphType.FETCH)
	User findByUsername(String username);
			
	User findByEmail(String email);
}
