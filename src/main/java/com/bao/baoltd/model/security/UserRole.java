package com.bao.baoltd.model.security;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bao.baoltd.model.User;

import lombok.AllArgsConstructor;

@Table(name="user_role")
@Entity
@AllArgsConstructor
public class UserRole {

	public UserRole() {}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userRoleId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="role_id")
	private Role role;
	
	public UserRole(User user, Role role) {
		this.user = user;
		this.role = role;
	}

	public Role getRole() {
		return role;
	}

	public Long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
