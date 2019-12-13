package com.security.app.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

//	@Enumerated(EnumType.STRING)
	private String role;

//	enum AuthorityType {
//		ROLE_ADMIN, ROLE_USER
//	}

	public Authority() {
		super();
	}

	public Authority(Integer id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", Role=" + role + "]";
	}

}
