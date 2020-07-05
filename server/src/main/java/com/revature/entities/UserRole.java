package com.revature.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_roles")
public class UserRole {
	
	@Id
	@Column(name="user_role_id")
	private int userRoleId;
	
	@Column(name="user_role_name")
	private String userRole;
	
	
	
	public UserRole(int userRoleId, String userRole) {
		super();
		this.userRoleId = userRoleId;
		this.userRole = userRole;
	}
	
	
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	
}
