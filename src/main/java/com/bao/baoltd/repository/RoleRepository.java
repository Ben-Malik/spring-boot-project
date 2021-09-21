package com.bao.baoltd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bao.baoltd.model.security.Role;

@Repository("RoleRepository")
public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByName(String name);

}
