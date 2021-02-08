package com.empresa.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="trabajador_id")
	private int trabajador_id;
	@Column(name="username",length=45)
	private String username;
	@Column(name="password",length=60)
	private String password;
	@Column(name="enabled",length=1)
	private String enabled;
	
	public Users() {
		super();
	}

	public Users(int id, int trabajador_id, String username, String password, String enabled) {
		super();
		this.id = id;
		this.trabajador_id = trabajador_id;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrabajador_id() {
		return trabajador_id;
	}

	public void setTrabajador_id(int trabajador_id) {
		this.trabajador_id = trabajador_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	

}
