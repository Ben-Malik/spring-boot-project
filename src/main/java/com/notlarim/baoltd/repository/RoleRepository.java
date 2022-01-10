package com.notlarim.notlarimltd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.notlarim.notlarimltd.model.security.Role;

@Repository("RoleRepository")
public interface RoleRepository extends CrudRepository<Role, Long>{

	Role findByName(String name);

}
