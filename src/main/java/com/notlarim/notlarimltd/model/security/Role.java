package com.notlarim.notlarimltd.model.security;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "role_id")
	private Long roleId;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "role", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Set<UserRole> userRoles = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String rolename) {
		this.name = rolename;		
	}
	
}
